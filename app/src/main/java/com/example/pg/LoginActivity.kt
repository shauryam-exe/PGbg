package com.example.pg

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.example.pg.model.LoginInfo
import kotlin.math.sign

class LoginActivity : AppCompatActivity() {

    lateinit var signInButton: Button
    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var signUp: TextView
    lateinit var progressBar: ProgressBar

    companion object {
        const val INTENT_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        signInButton = findViewById(R.id.signInButton)
        usernameInput = findViewById(R.id.emailEditText)
        passwordInput = findViewById(R.id.passwordEditText)
        signUp = findViewById(R.id.signUpTextView)
        progressBar = findViewById(R.id.signInProgressBar)

        signUp.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        signInButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Fill all credentials.", Toast.LENGTH_SHORT).show()
            } else {
                authenticateUser(username, password)
            }
        }
    }

    private fun authenticateUser(username: String, password: String) {
        progressBar.visibility = View.VISIBLE
        if (LoginInfo.searchUser(username, password)) {
            val timer = object : CountDownTimer(2000,1000) {
                override fun onTick(p0: Long) {

                }

                override fun onFinish() {
                    progressBar.visibility = View.GONE
                    showMainActivity(username)
                }
            }.start()
        }
        else {
            showToast()
        }
    }

    private fun showToast() {
        val text = "Check credentials, or Sign up now!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    private fun showMainActivity(username: String) {
        val user = Intent(this, MyselfActivity::class.java)
        user.putExtra(INTENT_KEY, username)
        startActivity(user)
    }
}
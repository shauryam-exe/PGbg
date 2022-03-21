package com.example.pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.pg.model.LoginInfo

class SignupActivity : AppCompatActivity() {

    lateinit var nameSignup: EditText
    lateinit var usernameText: EditText
    lateinit var passwordText: EditText
    lateinit var confirmPasswordText: EditText
    lateinit var signUpBtn: Button
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        nameSignup = findViewById(R.id.etName)
        usernameText = findViewById(R.id.etUsername)
        passwordText = findViewById(R.id.etPassword)
        confirmPasswordText = findViewById(R.id.etConfirmPassword)
        signUpBtn = findViewById(R.id.btnSignup)
        progressBar = findViewById(R.id.signUpProgressBar)

        signUpBtn.setOnClickListener {
            checkCredentials()
        }
    }

    private fun checkCredentials() {
        val name = nameSignup.text.toString()
        val username = usernameText.text.toString()
        val password = passwordText.text.toString()
        val confirmPassword = confirmPasswordText.text.toString()

        if (confirmPassword == password && username.isNotEmpty() && name.isNotEmpty()) {
            registerUser(username, password)
        }
    }

    private fun registerUser(username: String, password: String) {
        LoginInfo.users.add(Pair(username,password))
        progressBar.visibility = View.VISIBLE
        val timer = object : CountDownTimer(2000,1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                progressBar.visibility = View.GONE
                showMyselfActivity(username)
                nameSignup.text.clear()
                usernameText.text.clear()
                passwordText.text.clear()
                confirmPasswordText.text.clear()
            }
        }.start()
    }

    private fun showMyselfActivity(username: String) {
        val intent = Intent(this, MyselfActivity::class.java)
        intent.putExtra(LoginActivity.INTENT_KEY,username)
        startActivity(intent)
    }


}
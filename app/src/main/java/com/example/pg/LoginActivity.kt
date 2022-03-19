package com.example.pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pg.model.LoginInfo

class LoginActivity : AppCompatActivity() {

    lateinit var signInButton: Button
    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText

    companion object {
        const val INTENT_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        signInButton = findViewById(R.id.signInButton)
        usernameInput = findViewById(R.id.emailEditText)
        passwordInput = findViewById(R.id.passwordEditText)


        signInButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            authenticateUser(username, password)
        }
    }

    private fun authenticateUser(username: String, password: String) {
        if (LoginInfo.searchUser(username, password)) {
            showMainActivity(username)
        }
        else {
            showToast()
        }
    }

    private fun showToast() {
        val text = "Not Registered? Sign up now!"
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
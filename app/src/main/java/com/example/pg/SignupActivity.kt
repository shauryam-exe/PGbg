package com.example.pg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    lateinit var nameSignup : EditText
    lateinit var username : EditText
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var confirmPassword : EditText
    lateinit var signUpBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        nameSignup = findViewById(R.id.etName)
        username = findViewById(R.id.etUsername)
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        confirmPassword = findViewById(R.id.etConfirmPassword)
        signUpBtn = findViewById(R.id.btnSignup)

        val nameText = nameSignup.text.toString()
        val usernameText = username.text.toString()
        val emailText = email.text.toString()
        val passText = password.text.toString()
        val confirmPassText = confirmPassword.text.toString()

        signUpBtn.setOnClickListener {
            if (TextUtils.isEmpty(nameText) ||TextUtils.isEmpty(usernameText) ||TextUtils.isEmpty(emailText)
                ||TextUtils.isEmpty(passText) || TextUtils.isEmpty(confirmPassText)) {
                Toast.makeText(this, "Fill all credentials.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
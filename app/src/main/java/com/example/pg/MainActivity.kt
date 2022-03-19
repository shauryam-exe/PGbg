package com.example.pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pg.fragments.ChatFragment

class MainActivity : AppCompatActivity() {

    private var founder : Button? = null
    private var investor : Button? = null
    private var exploreNow : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        founder = findViewById(R.id.btnFounder)
        investor = findViewById(R.id.btnInvestor)
        exploreNow = findViewById(R.id.btnExplore)

        founder?.setOnClickListener {
            //Founder
        }

        investor?.setOnClickListener {
            //Investor
        }

        exploreNow?.setOnClickListener {
            //Explore
//            TODO("Change this implementation.")
            startActivity(Intent(this, HomePageActivity::class.java))
        }

    }
}
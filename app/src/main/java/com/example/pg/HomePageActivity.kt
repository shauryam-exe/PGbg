package com.example.pg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.pg.fragments.ChatFragment
import com.example.pg.fragments.HomeFragment
import com.example.pg.fragments.ProfileFragment
import com.example.pg.fragments.UploadFragment

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ChatFragment()).commit()

    }
}
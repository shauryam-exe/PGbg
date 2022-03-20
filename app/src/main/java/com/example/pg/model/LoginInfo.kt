package com.example.pg.model

import android.util.Log

object LoginInfo {
    val users = listOf(Pair("yash","password"),Pair("ankit","ankit"),Pair("1","1"))

    fun searchUser(name: String, password: String): Boolean {
        Log.d("check","User Working !!!")
        for (user in users) {
            if (user.first == name && user.second == password)
                return true
        }
        return false
    }
}
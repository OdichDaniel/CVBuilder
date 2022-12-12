package com.miu.cs473DE.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class StorageUtils(context: Context) {

    private val sharedPreferences: SharedPreferences
    init {
        sharedPreferences = context.getSharedPreferences("CVBuilder", Context.MODE_PRIVATE)
    }

    fun saveUser(username: String, password: String){
        sharedPreferences.edit()?.let { editor -> {
            editor.putString("username", username)
            editor.putString("password", password)
           editor.commit()
        } }
    }

    fun getUsername(): String? {
        return sharedPreferences.getString("username", "")
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("password", "")
    }

}
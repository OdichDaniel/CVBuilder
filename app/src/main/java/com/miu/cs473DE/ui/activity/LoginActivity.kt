package com.miu.cs473DE.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityLoginBinding
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.cs473DE.utils.AppUtils
import com.miu.cs473DE.utils.StorageUtils

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var storageUtils: StorageUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppUtils.setPref(this)
        storageUtils = StorageUtils(this)
        val username = storageUtils.getUsername()
        val password = storageUtils.getPassword()

        username?.let { binding.emailEdt.setText(it) }
        password?.let { binding.passwordEdit.setText(it) }
    }

    fun onLogin(view: View) {
        val username = binding.passwordEdit.text.toString().trim()
        val password = binding.emailEdt.text.toString().trim()

        if(username.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your username", Toast.LENGTH_LONG).show()
            return
        }
        if(password.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your password", Toast.LENGTH_LONG).show()
            return
        }
        startMainActivity(username, password)
    }

    private fun startMainActivity(username: String, password: String){
        storageUtils.saveUser(username, password)
        startActivity(Intent(this, MainActivity::class.java))
    }

}
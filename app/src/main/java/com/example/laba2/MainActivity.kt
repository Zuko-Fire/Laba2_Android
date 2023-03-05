package com.example.laba2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.laba2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickLogin(view: View) {
        var login = binding.editTextTextPersonName.text.toString()
        var passwd = binding.editTextTextPassword.text.toString()
        var arrr = resources.getStringArray(R.array.Logins)
        if (login in arrr  && passwd in arrr){
            var intent:Intent = Intent(this,autoriz::class.java)
            startActivity(intent)
        }
        else{
            binding.erroTv.text = "incorrect login or passwd"
        }

        }
    }

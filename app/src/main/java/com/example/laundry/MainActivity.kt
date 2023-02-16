package com.example.laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val btnLogin = findViewById<Button>(R.id.btnLogin)
        val txtUsername = findViewById<EditText>(R.id.txtUsername)

        btnLogin.setOnClickListener(){
            Intent(this, Home::class.java).also {
                it.putExtra("nama", txtUsername.text.toString())

                startActivity(it)
            }
        }
    }
}
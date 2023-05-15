package com.example.laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnPost = findViewById<Button>(R.id.button2)
        val btnPegawai = findViewById<Button>(R.id.button3)

        btnPost.setOnClickListener {
            Intent(this, Form::class.java).also {
                startActivity(it)
            }
        }
        btnPegawai.setOnClickListener {
            Intent(this, PegawaiActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
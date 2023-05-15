package com.example.laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLog = findViewById<Button>(R.id.btnLogin)
        val txtUsername = findViewById<EditText>(R.id.txtUsername)
        val txtPass = findViewById<EditText>(R.id.txtPassword)



        btnLog.setOnClickListener(){
        if(txtUsername.text.isNullOrEmpty() && txtPass.text.isNullOrEmpty()){
//            false
            Toast.makeText(this,"GAGAL", Toast.LENGTH_LONG).show()

        }
            else{

//           Toast.makeText(this, "BERHASIL LOGIN", Toast.LENGTH_LONG).show()
            Intent(this, MenuActivity::class.java).also{
                it.putExtra("username", txtUsername.text.toString())
                startActivity(it)
            }


        }


        }
//       val btnLogin = findViewById<Button>(R.id.btnLogin)
//        val txtUsername = findViewById<EditText>(R.id.txtUsername)
//asd
//        btnLogin.setOnClickListener(){
//            Intent(this, Form::class.java).also {
//                it.putExtra("nama", txtUsername.text.toString())
//
//                startActivity(it)
//            }
//        }
    }
}
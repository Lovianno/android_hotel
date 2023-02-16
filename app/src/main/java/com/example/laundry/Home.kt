package com.example.laundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class Home : AppCompatActivity() {
    val animals = mutableListOf("Lion", "Cat" , "Fish", "Rabbit", "Dog", "Rabbit")
    val manUtdPlayers = mutableListOf("Peter", "Gary", "Rio", "Nemanja", "Patrice")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val hewan = intent.getStringExtra("nama")
        animals.add(hewan.toString())
//        manUtdPlayers.add("Cristiano")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, animals)
        val lv = findViewById<ListView>(R.id.listView)
        lv.adapter = adapter

        lv.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, "Ini adalah ${animals[position]}", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Ini adalah ${animals[position]}", Toast.LENGTH_SHORT).show()

        }




    }


}
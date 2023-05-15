package com.example.laundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.loader.content.AsyncTaskLoader
import com.example.laundry.Api.ApiConfig
import com.example.laundry.Model.FoodResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.Objects

class FoodsActivity : AppCompatActivity()  {
    val rooms = arrayOf("V101", "V102", "V103")
    val foods = arrayOf("Burger", "Pizza", "Chicken")
    val drinks = arrayOf("Milo","Green Tea", "Orange Juice")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        createFood()

        setContentView(R.layout.activity_foods)
        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)
        val spinnerRoom = findViewById<Spinner>(R.id.cbRoom)
        val spinnerItem =  findViewById<Spinner>(R.id.cbItem)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        if(rb1.isChecked){
            val arrayAdapterItem = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, foods)
            spinnerItem.adapter = arrayAdapterItem
        }
        rb1.setOnClickListener{
            if(rb1.isChecked){
                val arrayAdapterItem = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, foods)
                spinnerItem.adapter = arrayAdapterItem
            }
        }
        rb2.setOnClickListener{
            if(rb2.isChecked){
                val arrayAdapterItem = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, drinks)
                spinnerItem.adapter = arrayAdapterItem
            }
        }




        val arrayAdapterRoom = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, rooms)
        spinnerRoom.adapter = arrayAdapterRoom

        btnSubmit.setOnClickListener {
            Toast.makeText(this,"INI adalah ${spinnerRoom.selectedItem}",Toast.LENGTH_SHORT).show();
        }

    }

    private fun createFood(){
        ApiConfig.getService().createFood(
            4000,
            "Kebab",
            "kebab.jpg",
            'F'
        ).enqueue(object: Callback<ArrayList<FoodResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<FoodResponseItem>>,
                response: Response<ArrayList<FoodResponseItem>>
            ) {
                val txtResponse = findViewById<TextView>(R.id.lbl1)
                val responseCode = response.code().toString()
                txtResponse.text = responseCode
            }


            override fun onFailure(call: Call<ArrayList<FoodResponseItem>>, t: Throwable) {
                val txtResponse = findViewById<TextView>(R.id.lbl1)
                txtResponse.text = t.message
            }

        })
    }
}


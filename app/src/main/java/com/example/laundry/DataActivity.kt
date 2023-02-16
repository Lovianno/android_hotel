package com.example.laundry

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataActivity : AppCompatActivity() {
    private val list = SocialMed()
    lateinit var adapter:PenggunaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val rvPengguna:RecyclerView= findViewById(R.id.rvPengguna)
        val textResponseCode:TextView = findViewById(R.id.textResponseCode)

        rvPengguna.setHasFixedSize(true)
        rvPengguna.layoutManager = LinearLayoutManager(this)
        rvPengguna.adapter = PenggunaAdapter(null)
        RetrofitClient.instance.getPengguna().enqueue(object : Callback<SocialMed>{
            override fun onResponse(
                call: Call<SocialMed>,
                response: Response<SocialMed>
            ) {
                val responseCode:String = response.code().toString()
                textResponseCode.text = responseCode
                val body:SocialMed? = response.body()
                adapter = PenggunaAdapter(body)
                rvPengguna.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<SocialMed>, t: Throwable) {

            }

        })



    }
}
package com.example.laundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laundry.Api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PegawaiActivity : AppCompatActivity() {
    private val dataPegawai = ArrayList<PegawaiResponseItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pegawai)
        showPegawai()

    }
    private fun showPegawai(){
        val rvPegawai = findViewById<RecyclerView>(R.id.rvPegawai)
        val title = findViewById<TextView>(R.id.titleForm)
        rvPegawai.setHasFixedSize(true)
        rvPegawai.layoutManager = LinearLayoutManager(this)
        ApiConfig.getService().getPegawai().enqueue(object : Callback<ArrayList<PegawaiResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<PegawaiResponseItem>>,
                response: Response<ArrayList<PegawaiResponseItem>>
            ) {
                val responseCode = response.code().toString()
                title.text = responseCode
                val listResponse = response.body()
                listResponse?.let { dataPegawai.addAll(it) }
                val adapter = PegawaiAdapter(dataPegawai)
               rvPegawai.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PegawaiResponseItem>>, t: Throwable) {
                title.text = t.message
            }
        })
    }
}
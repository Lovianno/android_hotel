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


class Form : AppCompatActivity() {
    private val dataPost = ArrayList<PostResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        showPosts()

//        ApiConfig.getService().getPost().enqueue(object : Callback<ArrayList<PostResponseItem>>{
//            override fun onResponse(
//                call: Call<ArrayList<PostResponseItem>>,
//                response: Response<ArrayList<PostResponseItem>>
//            ) {
//                if(response.isSuccessful){
//                    val responsePost =response.body()
//                    val responseCode = response.code().toString()
//                    txtResponse.text = responseCode
//                    response.body()?.let { list.addAll(it) }
//                    val adapter = PostAdapter(list)
//
//
////                    val dataPost = responsePost?.postResponse
////                    val postAdapter = PostAdapter(dataPost)
////                    post.apply {
////                        layoutManager = LinearLayoutManager(this@Form)
////                        setHasFixedSize(true)
////                        postAdapter.notifyDataSetChanged()
////                        adapter = postAdapter
////                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ArrayList<PostResponseItem>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//        ApiConfig.getService().getPost().enqueue(object : Callback<PostResponse>{
//            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
//                if(response.isSuccessful){
//                    val responsePost =response.body()
//                    val responseCode = response.code().toString()
//                    txtResponse.text = responseCode
//                    val dataPost = responsePost?.postResponse
//                    val postAdapter = PostAdapter(dataPost)
//                    post.apply {
//                        layoutManager = LinearLayoutManager(this@Form)
//                        setHasFixedSize(true)
//                        postAdapter.notifyDataSetChanged()
//                        adapter = postAdapter
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
//                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//
//        })


    }
    private fun showPosts(){
        val rvPost = findViewById<RecyclerView>(R.id.rvRecycle)
        val txtResponse = findViewById<TextView>(R.id.txtResponse)
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)
        ApiConfig.getService().getPost().enqueue(object : Callback<ArrayList<PostResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponseItem>>,
                response: Response<ArrayList<PostResponseItem>>
            ) {

                    val responseCode = response.code().toString()
                    txtResponse.text = responseCode
                    val listResponse = response.body()
                    listResponse?.let { dataPost.addAll(it) }
                    val adapter = PostAdapter(dataPost)
                    rvPost.adapter = adapter

            }

            override fun onFailure(call: Call<ArrayList<PostResponseItem>>, t: Throwable) {
                txtResponse.text = t.message
            }
        })
    }
}
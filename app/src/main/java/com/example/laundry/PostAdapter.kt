package com.example.laundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val dataPost: ArrayList<PostResponseItem>) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {
    class MyViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val titlePost =view.findViewById<TextView>(R.id.item_title)
        val bodyPost = view.findViewById<TextView>(R.id.item_body)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post,parent,false)
        return MyViewHolder(view)
    }
    override fun getItemCount(): Int {
        if(dataPost != null){
            return dataPost.size
        }
        return 0
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titlePost.text = dataPost?.get(position)?.id.toString()
        holder.bodyPost.text = dataPost?.get(position)?.body

    }
}
package com.example.laundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PenggunaAdapter(private val list:SocialMed?):RecyclerView.Adapter<PenggunaViewHolder>() {
//    Menambahkan View Item (item_pengguna)


    // Digunakan Untuk Set Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenggunaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengguna, parent, false)
        return PenggunaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.socialMed?.size?: 0
    }

    override fun onBindViewHolder(holder: PenggunaViewHolder, position: Int) {
        holder.bind(list?.socialMed?.get(position))
    }

}

class PenggunaViewHolder (itemView: View):RecyclerView.ViewHolder(itemView) {
    val textData:TextView
    init {
        textData = itemView.findViewById(R.id.textData)
    }


    //         Untuk mendapatkan Data dari GET API
    fun bind(penggunaResponse: SocialMedItem?){
        val data:String = "title : ${penggunaResponse?.title?:""}\n" +
                "body : ${penggunaResponse?.body?:""}"+
                "id : ${penggunaResponse?.id?:0}"
        textData.text = data

    }
}
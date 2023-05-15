package com.example.laundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PegawaiAdapter(val dataPegawai: ArrayList<PegawaiResponseItem>) : RecyclerView.Adapter<PegawaiAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtName = view.findViewById<TextView>(R.id.item_nama)
        val txtJabatan = view.findViewById<TextView>(R.id.item_jabatan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pegawai,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataPegawai.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtName.text = dataPegawai?.get(position)?.nama
        holder.txtJabatan.text = dataPegawai?.get(position)?.idJabatan.toString()
    }
}
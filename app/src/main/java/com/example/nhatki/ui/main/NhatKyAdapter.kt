package com.example.nhatki.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nhatki.R
import com.example.nhatki.data.model.NhatKy
import kotlinx.android.synthetic.main.item_nhatky.view.*

class NhatKyAdapter (val onItemClick : (NhatKy) -> Unit)  : RecyclerView.Adapter<NhatKyAdapter.ViewHolder>() {
    var data = mutableListOf<NhatKy>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nhatky,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner  class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(data: NhatKy) {
            itemView.tvTenNhatKy.text = data.tenNhatKy
            itemView.tvNgayviet.text = data.ngayViet

            itemView.setOnClickListener {
                onItemClick.invoke(data)
            }
        }
    }
}
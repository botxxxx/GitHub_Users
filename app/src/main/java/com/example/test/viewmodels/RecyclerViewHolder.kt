package com.example.test.viewmodels

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.data.RecyclerItemData

class RecyclerViewHolder(parent : ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)
    var data : RecyclerItemData? = null

    fun bind(data : RecyclerItemData?) {
        this.data = data
        nameView.text = data?.name
    }
}
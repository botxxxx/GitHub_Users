package com.example.test.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.test.data.RecyclerItemData
import com.example.test.viewmodels.RecyclerViewHolder

class RecyclerAdapter : PagingDataAdapter<RecyclerItemData, RecyclerViewHolder>(RecyclerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
//        val photo = getItem(position)
//        if (photo != null) {
//            holder.bind(photo)
//        }
        holder.bind(getItem(position))
    }
}

private class RecyclerDiffCallback : DiffUtil.ItemCallback<RecyclerItemData>() {
    override fun areItemsTheSame(oldItem: RecyclerItemData, newItem: RecyclerItemData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecyclerItemData, newItem: RecyclerItemData): Boolean {
        return oldItem == newItem
    }
}

package com.example.test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.drama.DramaData
import com.example.test.databinding.ListItemDramaBinding

class DramaAdapter : PagingDataAdapter<DramaData, DramaAdapter.DramaViewHolder>(DramaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DramaViewHolder {
        return DramaViewHolder(
            ListItemDramaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DramaViewHolder, position: Int) {
        val drama = getItem(position)
        if (drama != null) {
            holder.bind(drama)
        }
    }

    class DramaViewHolder(
        private val binding: ListItemDramaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DramaData?) {
            binding.apply {
                drama = item
                executePendingBindings()
            }
        }
    }
}

private class DramaDiffCallback : DiffUtil.ItemCallback<DramaData>() {
    override fun areItemsTheSame(oldItem: DramaData, newItem: DramaData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DramaData, newItem: DramaData): Boolean {
        return oldItem == newItem
    }
}

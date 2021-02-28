package com.example.test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.data.RecyclerItemData
import com.example.test.databinding.RecyclerviewItemBinding
import com.example.test.viewmodels.RecyclerViewModel

class RecyclerAdapter : ListAdapter<RecyclerItemData, RecyclerAdapter.ViewHolder>(
    RecyclerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: RecyclerviewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->

            }
        }

        fun bind(plantings: RecyclerItemData) {
            with(binding) {
                viewModel = RecyclerViewModel(plantings)
                executePendingBindings()
            }
        }
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

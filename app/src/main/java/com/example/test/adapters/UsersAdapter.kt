package com.example.test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.data.UsersData
import com.example.test.databinding.RecyclerviewItemBinding
import com.example.test.viewmodels.UserListViewModel

class UsersAdapter : ListAdapter<UsersData, RecyclerView.ViewHolder>(RecyclerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = getItem(position)
        (holder as UserViewHolder).bind(user)
    }

    class UserViewHolder(
        private val binding: RecyclerviewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.setClickListener { view ->
//
//            }
//        }

        fun bind(item: UsersData) {
            binding.apply {
                user = item
                executePendingBindings()
            }
        }
    }
}

private class RecyclerDiffCallback : DiffUtil.ItemCallback<UsersData>() {
    override fun areItemsTheSame(oldItem: UsersData, newItem: UsersData): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: UsersData, newItem: UsersData): Boolean {
        return oldItem == newItem
    }
}

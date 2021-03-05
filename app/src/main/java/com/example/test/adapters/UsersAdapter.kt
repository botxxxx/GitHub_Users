package com.example.test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.UsersData
import com.example.test.databinding.RecyclerviewItemBinding

class UsersAdapter : PagingDataAdapter<UsersData, UsersAdapter.UserViewHolder>(RecyclerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class UserViewHolder(
        private val binding: RecyclerviewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var data: UsersData? = null

        fun bind(item: UsersData?) {
            this.data = item
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

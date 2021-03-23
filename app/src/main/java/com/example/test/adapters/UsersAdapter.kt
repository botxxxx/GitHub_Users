package com.example.test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.users.UsersData
import com.example.test.databinding.ListItemUserBinding

class UsersAdapter : PagingDataAdapter<UsersData, UsersAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ListItemUserBinding.inflate(
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
        private val binding: ListItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var temp: UsersData? = null

        fun bind(item: UsersData?) {
            this.temp = item
            binding.apply {
                user = item
                executePendingBindings()
            }
        }
    }
}

private class UserDiffCallback : DiffUtil.ItemCallback<UsersData>() {
    override fun areItemsTheSame(oldItem: UsersData, newItem: UsersData): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: UsersData, newItem: UsersData): Boolean {
        return oldItem == newItem
    }
}

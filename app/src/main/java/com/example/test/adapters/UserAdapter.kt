package com.example.test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.UserListFragmentDirections
import com.example.test.data.users.UserData
import com.example.test.databinding.ListItemUserBinding

class UsersAdapter : PagingDataAdapter<UserData, UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.binding.apply {
                tvLogin.text = item.login
                tvAdmin.isVisible = item.site_admin
                Glide.with(root.context)
                    .load(item.avatar_url)
                    .circleCrop()
                    .placeholder(R.drawable.github_b_24px)
                    .into(ivAvatar)
                root.setOnClickListener {
                    val direction = UserListFragmentDirections.actionUserToDetail(item.login)
                    it.findNavController().navigate(direction)
                }
            }
        }
    }

}

class UserViewHolder(val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root)

private class UserDiffCallback : DiffUtil.ItemCallback<UserData>() {
    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem == newItem
    }
}

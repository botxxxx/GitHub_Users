package com.example.test.adapters

import android.util.*
import android.view.*
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.*
import com.example.test.*
import com.example.test.data.users.*
import com.example.test.databinding.*

class UsersAdapter : PagingDataAdapter<UserData, UsersAdapter.UserViewHolder>(UserDiffCallback()) {

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
        val item = getItem(position)
        holder.bind(item)
    }

    class UserViewHolder(
        private val binding: ListItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.user?.let { item ->
                    Log.d("com.example", "name:" + item.login)
                    navigateToDetail(item.login, view)
                }
            }
        }

        var temp: UserData? = null

        fun bind(item: UserData?) {
            this.temp = item
            binding.apply {
                user = item
                executePendingBindings()
            }
        }

        private fun navigateToDetail(login: String, view: View) {
            val direction = UserListFragmentDirections
                .actionUserToDetail(login)
            view.findNavController().navigate(direction)
        }
    }
}

private class UserDiffCallback : DiffUtil.ItemCallback<UserData>() {
    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem == newItem
    }
}

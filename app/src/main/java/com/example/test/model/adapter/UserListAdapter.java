package com.example.test.model.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.UserListFragmentDirections;
import com.example.test.data.users.UserData;
import com.example.test.databinding.ListItemUserBinding;

public class UserListAdapter extends PagingDataAdapter<UserData, UserListAdapter.UserViewHolder> {

    public UserListAdapter() {
        super(new UserDiffCallback());
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemUserBinding binding = ListItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserData item = getItem(position);
        holder.bind(item);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final ListItemUserBinding binding;
        private UserData temp;

        public UserViewHolder(ListItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(view -> {
                if (temp != null) {
                    Log.d("com.example", "name:" + temp.getLogin());
                    navigateToDetail(temp.getLogin(), view);
                }
            });
        }

        public void bind(UserData item) {
            this.temp = item;
            binding.setUser(item);
            binding.executePendingBindings();
        }

        private void navigateToDetail(String login, View view) {
            NavDirections direction = UserListFragmentDirections.actionUserToDetail(login);
            Navigation.findNavController(view).navigate(direction);
        }
    }

    private static class UserDiffCallback extends DiffUtil.ItemCallback<UserData> {
        @Override
        public boolean areItemsTheSame(@NonNull UserData oldItem, @NonNull UserData newItem) {
            return oldItem.getLogin().equals(newItem.getLogin());
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserData oldItem, @NonNull UserData newItem) {
            // Explicitly compare relevant fields
            return oldItem.getLogin().equals(newItem.getLogin()) &&
                    oldItem.getId() == newItem.getId() &&
                    // Add other relevant fields here
                    oldItem.getAvatar_url().equals(newItem.getAvatar_url());
        }
    }
}
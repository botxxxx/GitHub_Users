package com.example.test.model.adapter;

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

        holder.binding.getRoot().setOnClickListener(view -> {
            assert item != null;
            navigateToDetail(item.getLogin(), view);
        });
    }

    protected void navigateToDetail(String login, View view) {
        NavDirections direction = UserListFragmentDirections.actionUserToDetail(login);
        Navigation.findNavController(view).navigate(direction);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final ListItemUserBinding binding;

        public UserViewHolder(ListItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UserData item) {
            binding.setUser(item);
            binding.executePendingBindings();
        }
    }

    private static class UserDiffCallback extends DiffUtil.ItemCallback<UserData> {
        @Override
        public boolean areItemsTheSame(@NonNull UserData oldItem, @NonNull UserData newItem) {
            return oldItem.getLogin().equals(newItem.getLogin());
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserData oldItem, @NonNull UserData newItem) {
            return oldItem.getLogin().equals(newItem.getLogin()) &&
                    oldItem.getId() == newItem.getId() &&
                    oldItem.getAvatar_url().equals(newItem.getAvatar_url());
        }
    }
}
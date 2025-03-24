package com.example.test.model.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.data.users.UserData;
import com.example.test.databinding.ListItemUserBinding;

public class UserListLoadStateAdapter extends LoadStateAdapter<UserListLoadStateAdapter.LoadStateViewHolder> {

    @NonNull
    @Override
    public LoadStateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LoadState loadState) {
        ListItemUserBinding binding = ListItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LoadStateViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadStateViewHolder userViewHolder, @NonNull LoadState loadState) {
        userViewHolder.bind(loadState);
    }

    public static class LoadStateViewHolder extends RecyclerView.ViewHolder {
        private final ListItemUserBinding binding;
        private UserData temp;

        LoadStateViewHolder(ListItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(LoadState loadState) {
            if (loadState instanceof LoadState.Error) {
                LoadState.Error loadStateError = (LoadState.Error) loadState;
                binding.login.setText(loadStateError.getError().getLocalizedMessage());
            }
        }
    }
}
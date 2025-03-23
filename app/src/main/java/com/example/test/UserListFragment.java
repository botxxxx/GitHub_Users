package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;

import com.example.test.api.ApiService;
import com.example.test.data.users.UserData;
import com.example.test.databinding.FragmentUserListBinding;
import com.example.test.model.adapter.UserListAdapter;
import com.example.test.model.fragment.ViewBindingFragment;
import com.example.test.viewmodels.UserListViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserListFragment extends ViewBindingFragment<FragmentUserListBinding> {

    private UserListAdapter adapter;

    @NonNull
    @Override
    protected FragmentUserListBinding inflateBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentUserListBinding.inflate(inflater, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new UserListAdapter();
        getBinding().userList.setAdapter(adapter);

        subscribeUI();
    }

    private void subscribeUI() {
        UserListViewModel viewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        viewModel.getResult().observe(getViewLifecycleOwner(), pagedData -> adapter.submitData(getLifecycle(), pagedData));
    }
}

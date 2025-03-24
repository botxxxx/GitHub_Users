package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.databinding.FragmentUserListBinding;
import com.example.test.model.adapter.UserListAdapter;
import com.example.test.model.adapter.UserListLoadStateAdapter;
import com.example.test.model.fragment.ViewBindingFragment;
import com.example.test.viewmodels.UserListViewModel;

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

        initRecyclerviewAndAdapter();
        UserListViewModel viewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        viewModel.userDataFlowable.subscribe(moviePagingData -> adapter.submitData(getLifecycle(), moviePagingData));
    }

    private void initRecyclerviewAndAdapter() {
        adapter = new UserListAdapter();
        getBinding().userList.setAdapter(
                adapter.withLoadStateFooter(new UserListLoadStateAdapter())
        );
    }
}

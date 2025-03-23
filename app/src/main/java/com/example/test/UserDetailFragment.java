package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.data.details.UserDetail;
import com.example.test.databinding.FragmentUserDetailBinding;

import androidx.navigation.fragment.NavHostFragment;

import com.example.test.model.fragment.ViewBindingFragment;
import com.example.test.viewmodels.DetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class UserDetailFragment extends ViewBindingFragment<FragmentUserDetailBinding> {

    private DetailViewModel viewModel;
    private String login;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            UserDetailFragmentArgs args = UserDetailFragmentArgs.fromBundle(getArguments());
            login = args.getLogin();
        }
    }

    @NonNull
    @Override
    protected FragmentUserDetailBinding inflateBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentUserDetailBinding.inflate(inflater, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBinding().setClickListener(v -> {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        });

        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        subscribeUi(login);
    }

    private void subscribeUi(String login) {
        viewModel.getResult(login).enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<UserDetail> call, @NonNull Response<UserDetail> response) {
                if (response.isSuccessful() && response.body() != null) {
                    getBinding().setDetail(response.body());
                } else {
                    Toast.makeText(requireContext(), "Error fetching user details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserDetail> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), "Error fetching user details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
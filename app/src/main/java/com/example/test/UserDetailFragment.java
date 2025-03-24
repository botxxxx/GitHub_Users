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
import com.example.test.model.fragment.ViewBindingFragment;
import com.example.test.viewmodels.DetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class UserDetailFragment extends ViewBindingFragment<FragmentUserDetailBinding> {

    private DetailViewModel viewModel;
    private String login;
    private final CompositeDisposable disposables = new CompositeDisposable();

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
        Single<UserDetail> single = viewModel.getResult(login);
        Disposable disposable = single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        userDetail -> getBinding().setDetail(userDetail),
                        throwable -> {
                            Toast.makeText(requireContext(), "Error loading user details", Toast.LENGTH_SHORT).show();
                        }
                );
        disposables.add(disposable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
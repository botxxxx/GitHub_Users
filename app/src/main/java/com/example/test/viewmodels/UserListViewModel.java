package com.example.test.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData;

import com.example.test.data.users.UserData;
import com.example.test.data.users.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserListViewModel extends ViewModel {

    private final UserRepository userRepository;

    @Inject
    public UserListViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<PagingData<UserData>> getResult() {
        Log.e("","getResult()");
        return  userRepository.getSearchUser();
    }
}
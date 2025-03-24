package com.example.test.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.example.test.data.users.UserData;
import com.example.test.data.users.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

@HiltViewModel
public class UserListViewModel extends ViewModel {

    private final UserRepository userRepository;
    public Flowable<PagingData<UserData>>  userDataFlowable;


    @Inject
    public UserListViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        init();
    }

    public void init() {
        userDataFlowable = userRepository.getSearchUser();
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        assert userDataFlowable != null;
        PagingRx.cachedIn(userDataFlowable, coroutineScope);
    }
}
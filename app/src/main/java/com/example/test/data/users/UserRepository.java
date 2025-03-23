package com.example.test.data.users;

import androidx.lifecycle.LiveData;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import com.example.test.api.ApiService;

import javax.inject.Inject;

public class UserRepository {

    private final ApiService service;

    @Inject
    public UserRepository(ApiService service) {
        this.service = service;
    }

    public LiveData<PagingData<UserData>> getSearchUser() {
        Pager<Integer, UserData> pager = new Pager<>(
                new PagingConfig(20, 10,false),
                () -> new UserPagingSource(service)
        );
        return PagingLiveData.getLiveData(pager);
    }
}
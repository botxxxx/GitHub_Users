package com.example.test.data.users;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.example.test.api.ApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class UserRepository {

    private final ApiService service;

    @Inject
    public UserRepository(ApiService service) {
        this.service = service;
    }

    public Flowable<PagingData<UserData>> getSearchUser() {
        Pager<Integer, UserData> pager = new Pager<>(
                new PagingConfig(20, 20,false),
                () -> new UserPagingSource(service)
        );
        return PagingRx.getFlowable(pager);
    }
}
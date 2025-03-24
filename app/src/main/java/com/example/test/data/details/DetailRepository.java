package com.example.test.data.details;

import com.example.test.api.ApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class DetailRepository {

    private final ApiService service;

    @Inject
    public DetailRepository(ApiService service) {
        this.service = service;
    }

    public Single<UserDetail> getDetail(String login) {
        return service.getUserDetails(login);
    }
}
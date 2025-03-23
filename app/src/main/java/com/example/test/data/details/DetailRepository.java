package com.example.test.data.details;

import com.example.test.api.ApiService;

import javax.inject.Inject;

import retrofit2.Call;

public class DetailRepository {

    private final ApiService service;

    @Inject
    public DetailRepository(ApiService service) {
        this.service = service;
    }

    public Call<UserDetail> getSearchUser(String login) {
        return service.getDetails(login);
    }
}
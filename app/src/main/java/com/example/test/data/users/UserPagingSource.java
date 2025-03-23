package com.example.test.data.users;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;

import com.example.test.api.ApiService;
import com.example.test.api.UserListResponse;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Response;

public class UserPagingSource extends PagingSource<Integer, UserData> {

    private static final int UNSPLASH_STARTING_PAGE_INDEX = 1;

    private final ApiService service;

    public UserPagingSource(ApiService service) {
        this.service = service;
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, UserData> state) {
        return state.getAnchorPosition();
    }

    @NonNull
    @Override
    public LoadResult<Integer, UserData> load(@NonNull LoadParams<Integer> loadParams, @NonNull Continuation<? super LoadResult<Integer, UserData>> continuation) {
        int page = loadParams.getKey() != null ? loadParams.getKey() : UNSPLASH_STARTING_PAGE_INDEX;
        try {
            Call<UserListResponse> call = service.getUsers(page, 20, "followers:>10000", "contributions");
            Response<UserListResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                UserListResponse userResponse = response.body();
                LoadResult.Page<Integer, UserData> result = new LoadResult.Page<>(
                        userResponse.getItems(),
                        page == UNSPLASH_STARTING_PAGE_INDEX ? null : page - 1,
                        page == userResponse.getTotalCount() ? null : page + 1
                );
                return result;
            } else {
                return new LoadResult.Error<>(new IOException("Failed to load data"));
            }
        } catch (Exception e) {
            return new LoadResult.Error<>(e);
        }
    }
}
package com.example.test.data.users;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.example.test.api.ApiService;
import com.example.test.api.UserListResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserPagingSource extends RxPagingSource<Integer, UserData> {

    private static final int UNSPLASH_STARTING_PAGE_INDEX = 1;
    private static final int MAX_USERS = 100;

    private final ApiService service;
    private int totalUsersLoaded = 0;

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
    public Single<LoadResult<Integer, UserData>> loadSingle(@NonNull LoadParams<Integer> loadParams) {
        int page = loadParams.getKey() != null ? loadParams.getKey() : UNSPLASH_STARTING_PAGE_INDEX;
        try {
            Single<UserListResponse> single = service.getUsers(page, 20, "followers:>10000", "contributions");
            return single.subscribeOn(Schedulers.io())
                    .map(response -> toLoadResult(response.getItems(), page, response.getTotalCount()))
                    .onErrorReturn(LoadResult.Error::new);
        } catch (Exception e) {
            return Single.just(new LoadResult.Error(e));
        }
    }

    // Method to map UserData to LoadResult object
    private LoadResult<Integer, UserData> toLoadResult(List<UserData> items, int page, int totalCount) {
        // Update the total number of users loaded
        totalUsersLoaded += items.size();
        // Limit the totalCount to MAX_USERS
        int limitedTotalCount = Math.min(totalCount, MAX_USERS);
        int perPage = 20;
        int lastPage = (int) Math.ceil((double) limitedTotalCount / perPage);
        Integer nextKey = null;
        if (totalUsersLoaded < MAX_USERS && page < lastPage) {
            nextKey = page + 1;
        }
        return new LoadResult.Page<>(
                items,
                page == UNSPLASH_STARTING_PAGE_INDEX ? null : page - 1,
                nextKey
        );
    }
}
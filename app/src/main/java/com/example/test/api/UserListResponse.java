package com.example.test.api;

import androidx.annotation.NonNull;

import com.example.test.data.users.UserData;

import java.util.List;
import java.util.Objects;

public class UserListResponse {
    private final Integer total_count;
    private final Boolean incomplete_results;
    private final List<UserData> items;

    public UserListResponse(Integer total_count, Boolean incomplete_results, List<UserData> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public int getTotalCount() {
        return total_count;
    }

    public boolean isIncompleteResults() {
        return incomplete_results;
    }

    public List<UserData> getItems() {
        return items;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserListResponse{" +
                "total_count=" + total_count +
                ", incomplete_results=" + incomplete_results +
                ", items=" + items +
                '}';
    }
}
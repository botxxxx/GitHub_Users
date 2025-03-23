package com.example.test.api;

import com.example.test.data.details.UserDetail;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search/users")
    Call<UserListResponse> getUsers(
            @Query("page") int page,
            @Query("per_page") int per_page,
            @Query("q") String q,
            @Query("sort") String sort
    );

    @GET("users/{login}")
    Call<UserDetail> getDetails(
            @Path("login") String login
    );

    class Factory {
        private static final String BASE_URL = "https://api.github.com/";

        public static ApiService create() {
            HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
            logger.setLevel(Level.BASIC);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();

            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
    }
}
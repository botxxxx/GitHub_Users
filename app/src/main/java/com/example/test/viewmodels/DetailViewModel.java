package com.example.test.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.test.data.details.DetailRepository;
import com.example.test.data.details.UserDetail;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;

@HiltViewModel
public class DetailViewModel extends ViewModel {

    private final DetailRepository detailRepository;

    @Inject
    public DetailViewModel(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public Call<UserDetail> getResult(String login) {
        return detailRepository.getSearchUser(login);
    }
}
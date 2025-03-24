package com.example.test.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.test.data.details.DetailRepository;
import com.example.test.data.details.UserDetail;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class DetailViewModel extends ViewModel {

    private final DetailRepository detailRepository;

    @Inject
    public DetailViewModel(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public Single<UserDetail> getResult(String login) {
        return detailRepository.getDetail(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
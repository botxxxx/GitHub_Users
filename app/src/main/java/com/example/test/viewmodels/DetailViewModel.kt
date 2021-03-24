package com.example.test.viewmodels

import androidx.lifecycle.*
import com.example.test.data.details.DetailData
import com.example.test.data.details.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {

    suspend fun getResult(login: String): DetailData {
        return detailRepository.getSearchUser(login)
    }
}
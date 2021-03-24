package com.example.test.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.test.data.users.UserData
import com.example.test.data.users.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getResult(): Flow<PagingData<UserData>> {
        return userRepository.getSearchUser().cachedIn(viewModelScope)
    }
}
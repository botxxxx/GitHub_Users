package com.example.test.viewmodels

import androidx.lifecycle.*
import com.example.test.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject internal constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {
    //    val users: LiveData<List<UsersData>> = usersRepository.getUsers().asLiveData()
    val users = usersRepository.getPagingData

    fun insert(user: String) {
        viewModelScope.launch {
            usersRepository.insert(user)
        }
    }

    fun remove(user: UsersData) {
        viewModelScope.launch {
            usersRepository.remove(user)
        }
    }
}
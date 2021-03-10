package com.example.test.viewmodels

import androidx.lifecycle.*
import com.example.test.data.users.UsersData
import com.example.test.data.users.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject internal constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {
    //    val users: LiveData<List<UsersData>> = usersRepository.getUsers().asLiveData()
    val users = usersRepository.getUserPagingData

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
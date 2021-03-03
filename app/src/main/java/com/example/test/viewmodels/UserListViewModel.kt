package com.example.test.viewmodels

import androidx.lifecycle.*
import com.example.test.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject internal constructor(
    usersRepository: UsersRepository
) : ViewModel() {
    val users: LiveData<List<UsersData>> = usersRepository.getUsers().asLiveData()
}
package com.example.test.viewmodels

import android.content.Context
import androidx.lifecycle.*
import com.example.test.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject internal constructor(
    usersRepository: UsersRepository
) : ViewModel() {
    //    val users: LiveData<List<UsersData>> = usersRepository.getUsers().asLiveData()
    val users = usersRepository.getPagingData

    fun remove(app: Context, user: UsersData) = ioThread{
        AppDatabase.getDatabase(app).getUsersDao().delete(user)
    }

}
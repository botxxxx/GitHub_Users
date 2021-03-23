package com.example.test.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.test.data.users.UsersData
import com.example.test.data.users.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {
    //    val users: LiveData<List<UsersData>> = usersRepository.getUsers().asLiveData()
//    val users = usersRepository.getSearchUser
    private var searchResult: Flow<PagingData<UsersData>>? = null

    fun getResult(): Flow<PagingData<UsersData>> {
        val newResult = usersRepository.getSearchUser().cachedIn(viewModelScope)
        searchResult = newResult
        return newResult
    }

//    fun insert(user: String) {
//        viewModelScope.launch {
//            usersRepository.insert(user)
//        }
//    }
//
//    fun remove(user: UsersData) {
//        viewModelScope.launch {
//            usersRepository.remove(user)
//        }
//    }
}
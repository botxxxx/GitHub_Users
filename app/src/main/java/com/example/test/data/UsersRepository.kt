package com.example.test.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val dao: UsersDao
) {

    val getPagingData = Pager(
        config = PagingConfig(
            enablePlaceholders = false,
            pageSize = 60,
            maxSize = 200
        )
    ) {
        dao.getSource()
    }.flow

    fun getUser() = dao.getUser()

    suspend fun insert(user: String) {
        dao.insert(UsersData(userId = 0, name = user))
    }

    suspend fun remove(user: UsersData) {
        dao.delete(user)
    }
}

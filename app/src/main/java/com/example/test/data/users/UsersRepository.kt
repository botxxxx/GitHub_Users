package com.example.test.data.users

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.test.api.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val service: ApiService
) {

    fun getSearchUser(): Flow<PagingData<UsersData>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = 20
            ),
            pagingSourceFactory = { UsersPagingSource(service) }
        ).flow
    }

//    val getSearchUser = Pager(
//        config = PagingConfig(
//            enablePlaceholders = false,
//            pageSize = 20,
//            maxSize = 100
//        ),
//        pagingSourceFactory = { UsersPagingSource(service) }
//    ).flow

//    val getDatabaseUser = Pager(
//        config = PagingConfig(
//            enablePlaceholders = false,
//            pageSize = 20,
//            maxSize = 100
//        )
//    ) {
//        dao.getSource()
//    }.flow

//    fun getUser() = dao.getUser()

//    suspend fun insert(user: String) {
//        dao.insert(UsersData(id = 0, login = user))
//    }
//
//    suspend fun remove(user: UsersData) {
//        dao.delete(user)
//    }
}

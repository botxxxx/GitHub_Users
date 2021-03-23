package com.example.test.data.users

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.test.api.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val service: ApiService
) {

    fun getSearchUser(): Flow<PagingData<UserData>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = 20
            ),
            pagingSourceFactory = { UsersPagingSource(service) }
        ).flow
    }
}

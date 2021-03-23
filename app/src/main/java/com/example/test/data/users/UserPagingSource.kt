package com.example.test.data.users

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import com.example.test.api.ApiService

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UsersPagingSource(
    private val service: ApiService
) : PagingSource<Int, UserData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserData> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = service.getUsers(page = page)
            val users = response.items
            Page(
                data = users,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.total_count) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}

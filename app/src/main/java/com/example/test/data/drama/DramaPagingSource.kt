package com.example.test.data.drama

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import com.example.test.api.DramaService

class DramaPagingSource(private val service: DramaService) : PagingSource<Int, DramaData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DramaData> {
        val page = params.key ?: 1
        return try {
            val response = service.getDramaList()
            val drama = response.data
            Page(
                data = drama,
                prevKey = null,
                nextKey = null
//                prevKey = page - 1,
//                nextKey = page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}

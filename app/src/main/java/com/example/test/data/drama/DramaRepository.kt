package com.example.test.data.drama

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.test.api.DramaService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class DramaRepository @Inject constructor(
    private val service: DramaService
) {

    fun getSearchResult(): Flow<PagingData<DramaData>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { DramaPagingSource(service) }
        ).flow
    }

    companion object {
        var NETWORK_PAGE_SIZE = 25
    }
}

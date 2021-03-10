package com.example.test.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.test.data.drama.DramaData
import com.example.test.data.drama.DramaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DramaListViewModel @Inject constructor(
    private val repository: DramaRepository
) : ViewModel() {
    private var searchResult: Flow<PagingData<DramaData>>? = null

    fun getResult(): Flow<PagingData<DramaData>> {
        val newResult = repository.getSearchResult().cachedIn(viewModelScope)
        searchResult = newResult
        return newResult
    }
}
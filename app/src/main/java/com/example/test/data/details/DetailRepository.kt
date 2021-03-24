package com.example.test.data.details

import com.example.test.api.ApiService
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val service: ApiService
) {
    suspend fun getSearchUser(login: String) = service.getDetails(login)
}

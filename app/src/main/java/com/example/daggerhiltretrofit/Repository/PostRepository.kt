package com.example.daggerhiltretrofit.Repository

import com.example.daggerhiltretrofit.API.ApiServices
import com.example.daggerhiltretrofit.API.ApiServicesImplementation
import com.example.daggerhiltretrofit.Model.Post_response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject
constructor(private val apiServicesImplementation: ApiServicesImplementation) {

    fun getPost(): Flow<List<Post_response>> = flow {
        val response = apiServicesImplementation.getPosts()
        emit(response)
    }.flowOn(Dispatchers.IO)
}
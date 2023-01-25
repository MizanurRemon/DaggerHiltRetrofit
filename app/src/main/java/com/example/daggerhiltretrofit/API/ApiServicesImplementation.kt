package com.example.daggerhiltretrofit.API

import com.example.daggerhiltretrofit.Model.Post_response
import javax.inject.Inject

class ApiServicesImplementation @Inject constructor(private val apiServices: ApiServices) {
    suspend fun getPosts(): List<Post_response> = apiServices.getPosts()
}
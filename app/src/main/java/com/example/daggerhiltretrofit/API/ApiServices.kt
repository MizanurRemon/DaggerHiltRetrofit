package com.example.daggerhiltretrofit.API

import com.example.daggerhiltretrofit.Model.Post_response
import retrofit2.http.GET

interface ApiServices {

    @GET("posts")
    suspend fun getPosts(): List<Post_response>
}
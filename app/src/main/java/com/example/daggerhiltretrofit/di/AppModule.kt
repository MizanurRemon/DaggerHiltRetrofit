package com.example.daggerhiltretrofit.di

import com.example.daggerhiltretrofit.API.ApiServices
import com.example.daggerhiltretrofit.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    fun providesBaseUrl(): String = Constants.BASE_URL


    @Provides
    @Singleton
    fun retrofitBuilder(): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    fun providesApiService(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)
}
package com.example.mynews.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
//    private const val BASE_URL = "https://newsapi.org/v2/"

    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
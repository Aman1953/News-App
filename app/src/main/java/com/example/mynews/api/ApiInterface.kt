package com.example.mynews.api

import com.example.mynews.models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines?apiKey=c49ef6c8c3a1451b8d827cd617328fd1")
    suspend fun getData(@Query("country") country : String):Response<NewsData>
}
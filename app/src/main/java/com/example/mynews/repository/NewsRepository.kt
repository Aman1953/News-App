package com.example.mynews.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynews.api.ApiInterface
import com.example.mynews.models.NewsData

class NewsRepository(private val newsService: ApiInterface) {

    private val newsLiveData = MutableLiveData<NewsData>()

    val news: LiveData<NewsData>
        get()=newsLiveData

    suspend fun getNews(){
        val result = newsService.getData("in")
        if (result.body() != null){
            newsLiveData.postValue(result.body())
        }
    }
}
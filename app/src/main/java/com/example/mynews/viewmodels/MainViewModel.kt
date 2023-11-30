package com.example.mynews.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.models.NewsData
import com.example.mynews.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NewsRepository) : ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getNews()
        }
    }

    val news : LiveData<NewsData>
        get() = repository.news

}
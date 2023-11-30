package com.example.mynews.models

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
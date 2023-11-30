package com.example.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mynews.adapterClass.BreakingNewsAdapter
import com.example.mynews.api.ApiInterface
import com.example.mynews.api.RetrofitHelper
import com.example.mynews.databinding.ActivityMainBinding
import com.example.mynews.repository.NewsRepository
import com.example.mynews.viewmodels.MainViewModel
import com.example.mynews.viewmodels.MainViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val newsApi = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val repository = NewsRepository(newsApi)
        mainViewModel =
            ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java] //.get(MainViewModel::class.java)

        mainViewModel.news.observe(this, Observer {
            val newsAdapter = BreakingNewsAdapter(it.articles,this)
            binding.bknRecyclerView.adapter = newsAdapter
        })

    }

}
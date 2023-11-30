package com.example.mynews

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.mynews.databinding.ActivityFullNewsBinding
import com.example.mynews.databinding.ActivityMainBinding
import com.example.mynews.viewmodels.MainViewModel

class FullNews : AppCompatActivity() {

    private lateinit var binding: ActivityFullNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val receiveData1 =
            if (intent.hasExtra("itemImage")) intent.getStringExtra("itemImage").toString()
            else ""
        val receiveData2 =
            if (intent.hasExtra("itemDescription")) intent.getStringExtra("itemDescription").toString() else ""

        val receiveData3 =
            if (intent.hasExtra("itemAuthor")) intent.getStringExtra("itemAuthor").toString() else ""

        if (receiveData1.isNotEmpty()) {
            Glide.with(this@FullNews).load(receiveData1).into(binding.itemImage)
        }

        if (receiveData2.isNotEmpty()) {
            binding.itemTitle.text = receiveData2
        }

        if (receiveData3.isNotEmpty()) {
            val concatenatedText = " ~  $receiveData3"
            binding.itemAuthor.text = concatenatedText
        }



    }
}
package com.example.mynews.adapterClass

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mynews.FullNews
import com.example.mynews.R
import com.example.mynews.models.Article

class BreakingNewsAdapter(private val newsList : List<Article>,private  val context:Context): Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.each_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newsItem = newsList[position]
        Glide.with(context).load(newsItem.urlToImage).into(holder.image)
        holder.text.text = newsItem.title
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Author : "+newsItem.author,Toast.LENGTH_SHORT).show()
            val intent = Intent(context,FullNews::class.java)
            intent.putExtra("itemImage",newsItem.urlToImage)
            intent.putExtra("itemDescription",newsItem.description)
            intent.putExtra("itemAuthor",newsItem.author)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}
class MyViewHolder(itemView: View) : ViewHolder(itemView){
    val image : ImageView = itemView.findViewById(R.id.productImage)
    val text : TextView = itemView.findViewById(R.id.news_headlines)

}
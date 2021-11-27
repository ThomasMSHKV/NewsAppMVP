package com.example.newsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.api.Article
import com.example.newsapp.data.presenter.NewsCallback

class NewsAdapter(val callback: NewsCallback) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var itemNews = mutableListOf<Article>()

    fun setData(list: List<Article>){
        itemNews = list as MutableList<Article>
        notifyDataSetChanged()
    }

    fun replaceList(article: List<Article>){
        itemNews.addAll(article)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent. context)
            .inflate(R.layout.news_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.root.setOnClickListener {
            callback.openFragment(itemNews[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(itemNews[position].image).into(holder.newsImage)
        holder.title.text = itemNews[position].title
        holder.description.text = itemNews[position].description
    }

    override fun getItemCount(): Int {
        return itemNews.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var root: CardView = itemView.findViewById(R.id.card_view)
        var newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        var title: TextView = itemView.findViewById(R.id.newsTitle)
        var description: TextView = itemView.findViewById(R.id.newsDescription)
    }
}

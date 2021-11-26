package com.example.newsapp.view.adapter

import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.presenter.NewsCallback

class NewsAdapter(val callback: NewsCallback): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var roo: CardView = itemView.findViewById(R.id.card_view)
        var
    }
}
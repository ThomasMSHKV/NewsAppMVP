package com.example.newsapp.data.presenter

import com.example.newsapp.data.api.Article

interface NewsListContract {
    interface View{
        fun setData(article: List<Article>)
        fun replaceData(article: List<Article>)
    }
}
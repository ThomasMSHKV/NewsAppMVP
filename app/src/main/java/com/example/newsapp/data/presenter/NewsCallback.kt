package com.example.newsapp.data.presenter

import com.example.newsapp.data.api.Article

interface NewsCallback {

    fun setData(article: Article)
    fun openFragment(article: Article)
}
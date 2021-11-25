package com.example.newsapp.data.retrofit

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class NewsRepository: CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val newsApi: NewsApi = Retrofit.Builder()
        .baseUrl("https://gnews.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)

    fun getData() = async {
        newsApi.getNews()
            .execute()
            .body()
            ?.articles
    }
}
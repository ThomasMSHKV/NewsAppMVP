package com.example.newsapp.data.retrofit

import com.example.newsapp.data.api.MainNews
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("api/v4/search?q=example&token=93736b37055d4e5caa0680dac04e2afc")
    fun getNews(): Call<MainNews>
}
package com.example.indianaffairs.api

import com.example.indianaffairs.models.NewsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface IndianAffairsAPI {


    @Headers("X-RapidAPI-Key:c067ca75dcmsh429011dd9300cb1p112e5fjsnb7140aa4edd3",
        "X-RapidAPI-Host:newsi-api.p.rapidapi.com")
    @GET("/api/category?language=en&country=in&sort=top&page=1&limit=20")
    suspend fun getNews(@Query("category") category: String): Response<List<NewsItem>>
}
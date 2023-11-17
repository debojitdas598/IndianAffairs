package com.example.indianaffairs.api

import com.example.indianaffairs.models.NewsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface IndianAffairsAPI {

    @GET
    @Headers("X-RapidAPI-Key:c067ca75dcmsh429011dd9300cb1p112e5fjsnb7140aa4edd3",
        "X-RapidAPI-Host:newsi-api.p.rapidapi.com")
    suspend fun getNews(): Response<List<NewsItem>>
}
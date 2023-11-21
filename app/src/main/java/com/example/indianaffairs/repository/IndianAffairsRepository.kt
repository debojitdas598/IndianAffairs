package com.example.indianaffairs.repository

import com.example.indianaffairs.api.IndianAffairsAPI
import com.example.indianaffairs.models.NewsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class IndianAffairsRepository @Inject constructor(private val indianAffairsAPI: IndianAffairsAPI) {

   private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news: StateFlow<List<NewsItem>>
        get() = _news
    suspend fun getNews(category: String){
        val response = indianAffairsAPI.getNews(category)
        if(response.isSuccessful && response.body()!=null){
            _news.emit(response.body()!!)
        }
    }

}
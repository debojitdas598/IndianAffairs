package com.example.indianaffairs.ViewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indianaffairs.models.NewsItem
import com.example.indianaffairs.repository.IndianAffairsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: IndianAffairsRepository,
    private val savedStateHandle: SavedStateHandle) :ViewModel() {

        val news : StateFlow<List<NewsItem>>
            get() = repository.news

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category")?:"sport"
            repository.getNews(category)
        }
    }

}
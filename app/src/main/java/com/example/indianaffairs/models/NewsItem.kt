package com.example.indianaffairs.models

data class NewsItem(
    val _id: String,
    val body: Any,
    val hasBody: Boolean,
    val image: String,
    val link: String,
    val publishedAt: String,
    val publishedTimestamp: Int,
    val shortLink: String,
    val sourceName: String,
    val title: String
)
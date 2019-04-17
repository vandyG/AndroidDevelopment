package com.example.newsapp

class Root(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<Article>
)

class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

class Source(
    val id: String,
    val name: String
)

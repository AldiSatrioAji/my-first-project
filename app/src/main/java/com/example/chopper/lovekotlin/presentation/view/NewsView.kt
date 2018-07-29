package com.example.chopper.lovekotlin.presentation.view

import com.example.chopper.lovekotlin.base.BaseView
import com.example.chopper.lovekotlin.model.NewsResponse

interface NewsView : BaseView {
    fun displayNews(newsResponse: NewsResponse)
}
package com.example.chopper.lovekotlin.repository

import com.example.chopper.lovekotlin.model.NewsResponse

interface NewsRepository {

    interface GetNewsListsCallback<T> {
        fun onSubscribe()
        fun onFetchData(news: T)
        fun onCompleteFetchData()
        fun onErrorOcurred()
    }

    fun getNewsLists(getNewsListsCallback: GetNewsListsCallback<NewsResponse>)
}
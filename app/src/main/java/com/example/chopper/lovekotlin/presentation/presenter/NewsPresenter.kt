package com.example.chopper.lovekotlin.presentation.presenter

import com.example.chopper.lovekotlin.base.BasePresenter
import com.example.chopper.lovekotlin.model.NewsResponse
import com.example.chopper.lovekotlin.repository.NewsRepositoryImpl
import com.example.chopper.lovekotlin.presentation.view.NewsView
import com.example.chopper.lovekotlin.repository.NewsRepository
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepositoryImpl: NewsRepositoryImpl) : BasePresenter<NewsView>() {

    fun fetchNews(){
        newsRepositoryImpl.getNewsLists(object : NewsRepository.GetNewsListsCallback<NewsResponse> {
            override fun onSubscribe() {
                newsView?.showLoading()
            }

            override fun onFetchData(news: NewsResponse) {
                newsView?.displayNews(news)
            }

            override fun onCompleteFetchData() {
                newsView?.hideLoading()
            }

            override fun onErrorOcurred() {
                newsView?.hideLoading()
            }
        })
    }
}
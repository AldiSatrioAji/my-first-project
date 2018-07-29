package com.example.chopper.lovekotlin.repository

import com.example.chopper.lovekotlin.model.NewsResponse
import com.example.chopper.lovekotlin.network.NewsNetworkService
import com.example.chopper.lovekotlin.presentation.adapter.NewsAdapter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsNetworkService: NewsNetworkService) : NewsRepository {

    fun observeResponse(): Observable<NewsResponse> {
        return newsNetworkService.getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getNewsLists(getNewsListsCallback: NewsRepository.GetNewsListsCallback<NewsResponse>) {
        observeResponse().subscribe(object : Observer<NewsResponse> {
            override fun onComplete() {
                getNewsListsCallback.onCompleteFetchData()
            }

            override fun onSubscribe(d: Disposable) {
                getNewsListsCallback.onSubscribe()
            }

            override fun onNext(t: NewsResponse) {
                getNewsListsCallback.onFetchData(t)
            }

            override fun onError(e: Throwable) {
                getNewsListsCallback.onErrorOcurred()
            }
        })
    }
}
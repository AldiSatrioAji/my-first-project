package com.example.chopper.lovekotlin.network

import com.example.chopper.lovekotlin.BuildConfig
import com.example.chopper.lovekotlin.model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsNetworkService {

    @GET(BuildConfig.BOOK_ENDPOINT)
    fun getResponse() : Observable<NewsResponse>

}
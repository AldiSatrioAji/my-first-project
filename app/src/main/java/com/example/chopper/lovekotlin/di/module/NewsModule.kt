package com.example.chopper.lovekotlin.di.module

import com.example.chopper.lovekotlin.BuildConfig
import com.example.chopper.lovekotlin.network.NewsNetworkService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(OkHttpModule::class))
class NewsModule {

    @Provides
    @Singleton
    fun providesCall(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BOOK_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesNetwork(retrofit: Retrofit) : NewsNetworkService {
        return retrofit.create(NewsNetworkService::class.java)
    }

}
package com.example.chopper.lovekotlin.di.component

import com.example.chopper.lovekotlin.NewsActivity
import com.example.chopper.lovekotlin.di.module.ContextModule
import com.example.chopper.lovekotlin.di.module.NewsModule
import com.example.chopper.lovekotlin.di.module.OkHttpModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NewsModule::class, ContextModule::class, OkHttpModule::class))
interface NewsComponent {
    fun inject(newsActivity: NewsActivity)
}
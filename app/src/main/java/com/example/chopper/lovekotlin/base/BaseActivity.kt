package com.example.chopper.lovekotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chopper.lovekotlin.di.component.DaggerNewsComponent
import com.example.chopper.lovekotlin.di.component.NewsComponent
import com.example.chopper.lovekotlin.di.module.ContextModule
import com.example.chopper.lovekotlin.di.module.NewsModule
import com.example.chopper.lovekotlin.di.module.OkHttpModule

abstract class BaseActivity : AppCompatActivity() {

    val newsComponent: NewsComponent by lazy {
        DaggerNewsComponent.builder()
                .contextModule(ContextModule(this))
                .newsModule(NewsModule())
                .okHttpModule(OkHttpModule())
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(newsComponent)
    }

    abstract fun inject(newsComponent: NewsComponent)

}
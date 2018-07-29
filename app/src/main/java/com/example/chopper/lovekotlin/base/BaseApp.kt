package com.example.chopper.lovekotlin.base

import android.app.Application
import android.content.Context
import android.util.Log
import android.util.Log.INFO
import com.example.chopper.lovekotlin.BuildConfig
import com.example.chopper.lovekotlin.di.component.DaggerNewsComponent
import com.example.chopper.lovekotlin.di.component.NewsComponent
import com.example.chopper.lovekotlin.di.module.ContextModule
import com.example.chopper.lovekotlin.di.module.NewsModule
import com.example.chopper.lovekotlin.di.module.OkHttpModule
import timber.log.Timber

class BaseApp : Application() {



    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
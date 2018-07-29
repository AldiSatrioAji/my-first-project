package com.example.chopper.lovekotlin.di.module

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = arrayOf(ContextModule::class))
class OkHttpModule {

    @Provides
    @Singleton
    fun provideCache(cache: Cache, context: Context): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor {
                    var request: Request = it.request()
                    Timber.d(request.method())
                    if(isNetworkAvailable(context)){
                        request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                    }else{
                        request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                    }
                    it.proceed(request)
                }.build()
    }

    @Provides
    @Singleton
    fun isNetworkAvailable(context: Context) : Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager){
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected?: false
        }else false
    }

    @Provides
    @Singleton
    fun cache(context: Context) : Cache {
        return Cache(context.cacheDir, 10 * 1024 * 1024)
    }
}
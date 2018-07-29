package com.example.chopper.lovekotlin.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class Article(
        val source: Source,
        val author: String,
        var title: String?,
        val description: String,
        val url: String,
        var urlToImage: String?,
        val publishedAt: String
)
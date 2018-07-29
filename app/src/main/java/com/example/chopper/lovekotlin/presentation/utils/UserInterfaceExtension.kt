package com.example.chopper.lovekotlin.presentation.utils

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun View.toGone() {
    visibility = View.GONE
}

fun View.toVisible() {
    visibility = View.VISIBLE
}


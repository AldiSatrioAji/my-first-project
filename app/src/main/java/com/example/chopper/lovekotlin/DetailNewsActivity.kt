package com.example.chopper.lovekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.chopper.lovekotlin.R
import com.example.chopper.lovekotlin.model.Article
import com.example.chopper.lovekotlin.presentation.utils.Const
import com.example.chopper.lovekotlin.presentation.utils.toGone
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*
import kotlinx.android.synthetic.main.activity_detail_news.*
import timber.log.Timber

class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        Timber.d(getValue(Const.DETAIL_IMAGE))

        val title = getValue(Const.DETAIL_TITLE)
        val image = getValue(Const.DETAIL_IMAGE)

        detailsTitle.text = title
        Glide.with(this)
                .load(image)
                .into(ivDetail)
    }

    fun getValue(value: String): String {
        return intent.getStringExtra(value)
    }

}
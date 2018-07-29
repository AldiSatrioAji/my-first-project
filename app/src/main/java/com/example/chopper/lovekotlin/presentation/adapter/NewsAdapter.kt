package com.example.chopper.lovekotlin.presentation.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.chopper.lovekotlin.R
import com.example.chopper.lovekotlin.model.Article
import com.example.chopper.lovekotlin.presentation.utils.toGone
import kotlinx.android.synthetic.main.news_list.view.*
import java.util.*


class NewsAdapter(private val context: Context, private var listOfNews: ArrayList<Article>, val moveIntent: (Article) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(parent.inflate(R.layout.news_list))

    override fun getItemCount() = listOfNews.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bind(listOfNews.get(position), moveIntent)

    fun isEmpty(text: CharSequence) = text.isEmpty()

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int) = LayoutInflater.from(context).inflate(layoutRes, this, false)

    fun deleteAll() = listOfNews.clear()

    fun ImageView.loadUrl(context: Context, from: String?) {
        if (urlImage != null) {
            Glide.with(context)
                    .load(from)
                    .into(urlImage)
        }
    }


    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article, moveIntent: (Article) -> Unit) = with(itemView) {
            if (isEmpty(tvDescBerita.text)) tvDescBerita.toGone() else tvDescBerita.text = article.description
            if (isEmpty(newsPublishedDate.text)) newsPublishedDate.toGone() else newsPublishedDate.text = article.publishedAt

            tvJudulBerita.text = article.title
            urlImage.loadUrl(context, article.urlToImage)

            setOnClickListener { moveIntent(article) }
        }
    }

}

package com.example.chopper.lovekotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.chopper.lovekotlin.base.BaseActivity
import com.example.chopper.lovekotlin.di.component.NewsComponent
import com.example.chopper.lovekotlin.model.Article
import com.example.chopper.lovekotlin.model.NewsResponse
import com.example.chopper.lovekotlin.presentation.adapter.NewsAdapter
import com.example.chopper.lovekotlin.presentation.presenter.NewsPresenter
import com.example.chopper.lovekotlin.presentation.utils.Const
import com.example.chopper.lovekotlin.presentation.utils.toGone
import com.example.chopper.lovekotlin.presentation.utils.toVisible
import com.example.chopper.lovekotlin.presentation.view.NewsView
import kotlinx.android.synthetic.main.activity_news.*
import java.util.*
import javax.inject.Inject

class NewsActivity : BaseActivity(), NewsView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var newsPresenter: NewsPresenter

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        setupRvLayout()

        newsPresenter.attachView(this)
        newsPresenter.fetchNews()

        swipeContainer.setOnRefreshListener(this)
    }

    fun setupRvLayout() {
        with(rv_book_list) {
            layoutManager = LinearLayoutManager(this@NewsActivity)
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            isDrawingCacheEnabled = true
            drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
        }
    }

    override fun inject(newsComponent: NewsComponent) {
        newsComponent.inject(this)
    }

    override fun displayNews(newsResponse: NewsResponse) {
        newsAdapter = NewsAdapter(this, newsResponse.articles as ArrayList<Article>, {
            val intent = Intent(this, DetailNewsActivity::class.java)
            with(intent) {
                putExtra(Const.DETAIL_TITLE, it.title)
                putExtra(Const.DETAIL_IMAGE, it.urlToImage)
            }
            startActivity(intent)
        })
        rv_book_list.adapter = newsAdapter
    }

    override fun showLoading() {
        newsProgressBar.toVisible()
    }

    override fun hideLoading() {
        newsProgressBar.toGone()
    }

    override fun onDestroy() {
        super.onDestroy()
        newsPresenter.detachView()
    }

    override fun onRefresh() {
        swipeContainer.isRefreshing = false
        with(newsAdapter) {
            deleteAll()
            notifyDataSetChanged()
        }
        newsPresenter.fetchNews()
    }
}
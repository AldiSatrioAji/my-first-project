package com.example.chopper.lovekotlin.base

open class BasePresenter<T : BaseView> : Presenter<T> {

    var newsView: T? = null

    override fun attachView(view: T) {
        this.newsView = view
    }

    override fun detachView() {
        this.newsView = null
    }

}
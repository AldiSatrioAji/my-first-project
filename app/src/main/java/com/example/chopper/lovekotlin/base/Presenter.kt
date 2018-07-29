package com.example.chopper.lovekotlin.base

interface Presenter<in V : BaseView> {

    fun attachView(view: V)
    fun detachView()

}
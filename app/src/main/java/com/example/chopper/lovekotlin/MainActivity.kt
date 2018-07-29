package com.example.chopper.lovekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chopper.lovekotlin.presentation.presenter.NewsPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        book.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }
    }
}
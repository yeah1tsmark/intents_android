package com.example.intents_app_mark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.intents_app_mark.R.*

class WebsiteActivity : AppCompatActivity() {

    lateinit var thiswebview:WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_website)

        thiswebview = findViewById(id.my_web_view)

        val webSettings = thiswebview.settings
        webSettings.javaScriptEnabled = true
        thiswebview.loadUrl("https://google.com")




    }
}
package com.pickcocast.hallowpickco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {
    private lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        web = findViewById(R.id.web_view)
        val url = intent.getStringExtra("url")

        webMove(url)
    }

    private fun webMove(url: String?){
        web.loadUrl(url)
    }
}

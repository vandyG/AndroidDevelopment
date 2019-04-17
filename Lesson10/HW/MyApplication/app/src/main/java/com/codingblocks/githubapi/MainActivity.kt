package com.codingblocks.githubapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://api.github.com/users"
        val client = OkHttpClient()

        val request = Request.Builder().url(url).build()


    }

}

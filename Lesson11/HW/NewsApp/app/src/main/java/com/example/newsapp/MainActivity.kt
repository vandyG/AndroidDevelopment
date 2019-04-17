package com.example.newsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val baseUrl = "https://newsapi.org/v2/top-headlines"
    val apiKey = "748eafa8166149bf8306558d7f29f302"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient.Builder().build()

        val category = etCategory.text

        val url = "$baseUrl?country=in&category=$category&apiKey=$apiKey"

        Log.e("TAG", url)

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body()?.string()

                val gson = Gson()

                val root = gson.fromJson(result, Root::class.java)

                val adapter = ArticleAdapter(root.articles)

                val recyclerView = rvNews

                runOnUiThread{
                    recyclerView.layoutManager = LinearLayoutManager(baseContext)
                    recyclerView.adapter = adapter
                }
            }

        })
    }
}

package com.codingblocks.jsonpardingapp

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val baseURL = "https://api.github.com/"
    private val searchPoint = "search/users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient.Builder().build()

        val name = etUser.text

        val request = Request.Builder().url("$baseURL$searchPoint?q=$name").build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {

                val result = response.body()?.string()

                val root = convertBodyToRoot(result)

            }

        })
    }

    fun convertBodyToRoot(result : String?):Root{
        val resultJson = JSONObject(result)

        val totalCount = resultJson.getInt("total_count")
        val incompleteResults = resultJson.getBoolean("incomplete_results")
        val items = resultJson.getJSONArray("items")

        val itemsList = arrayListOf<User>()

        for (i in 0 until items.length()){
            val currentItem = items.getJSONObject(i)
            val currentLogin = currentItem.getString("login")
            val currentId = currentItem.getInt("id")
            val currentNodeId = currentItem.getString("node_id")
            val currentAvatarUrl = currentItem.getString("avatar_url")
            val currentUrl = currentItem.getString("url")
            val currentHtmlUrl = currentItem.getString("html_url")

            val item = User(currentLogin, currentId, currentNodeId, currentAvatarUrl, currentUrl, currentHtmlUrl)

            itemsList.add(item)
        }
        return Root(totalCount, incompleteResults, itemsList)
    }
}

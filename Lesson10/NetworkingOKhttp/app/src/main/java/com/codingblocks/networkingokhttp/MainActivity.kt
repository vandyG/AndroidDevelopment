package com.codingblocks.networkingokhttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://api.github.com/users/mojombo/followers"

        val client = OkHttpClient()

        val request = Request.Builder().url(url).build()

        val call = (client).newCall(request)

        val maxRetries = 4

        call.enqueue(object : Callback {

            var retries = 0

            override fun onFailure(call: Call, e: IOException) {
                if (++retries < maxRetries) {
                    call.cancel()
                    call.enqueue(this)
                }
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {

                val result = response.body()?.string()
                runOnUiThread{
                    tvBody.text = result
                }
            }
        })
    }
}

package com.example.services

import android.app.IntentService
import android.content.Intent
import android.util.Log
import kotlin.concurrent.thread

class BackgroundIntentService : IntentService("BackgroundIntentService") {

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy")
    }

    override fun onHandleIntent(intent: Intent?) {

        Log.e("TAG", "Intent Service Started")

        Thread.sleep(60000)
    }
}
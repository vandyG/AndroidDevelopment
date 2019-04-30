package com.example.location

import android.content.Context
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val provider = locationManager.allProviders

        provider.forEach {
            Log.e("PROVIDER", it)
        }

        Log.e("IS_ENABLED", locationManager.isLocationEnabled.toString())
    }
}

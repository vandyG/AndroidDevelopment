package com.codingblocks.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


           btnAdd.setOnClickListener {
               var result = Integer.parseInt(et1.text.toString()) + Integer.parseInt(et2.text.toString())
               tvResult.text = "" + result
               et1.text = null
               et2.text = null
           }
           btnSub.setOnClickListener {
               var result = Integer.parseInt(et1.text.toString()) - Integer.parseInt(et2.text.toString())
               tvResult.text = "" + result
               et1.text = null
               et2.text = null
           }
           btnMul.setOnClickListener {
               var result = Integer.parseInt(et1.text.toString()) * Integer.parseInt(et2.text.toString())
               tvResult.text = "" + result
               et1.text = null
               et2.text = null
           }
           btnDiv.setOnClickListener {
               var result = Integer.parseInt(et1.text.toString()) / Integer.parseInt(et2.text.toString())
               tvResult.text = "" + result
               et1.text = null
               et2.text = null
           }

    }
}

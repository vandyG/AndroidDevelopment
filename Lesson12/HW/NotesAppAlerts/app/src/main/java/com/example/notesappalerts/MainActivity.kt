package com.example.notesappalerts

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_view.*
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.item_row.*

class MainActivity : AppCompatActivity() {


    lateinit var sharedPrefs: SharedPreferences
    private val notes = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        fab.setOnClickListener {
            showAlert()
        }

        val adapter = NotesAdapter(notes)
        adapter.notifyDataSetChanged()

        rvNotes.adapter = adapter
        rvNotes.layoutManager = LinearLayoutManager(this)

    }

    private fun showAlert() {

        val dialogView = layoutInflater.inflate(R.layout.dialog_view, null, false)

        val alertDialog = AlertDialog.Builder(this).setTitle("New Note")
            .setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("Done") { dialog, which ->
                val editor = sharedPrefs.edit()
                val map = sharedPrefs.all
                var count : Int = map["0"].toString().toInt()
                count.inc()
                Log.e("COUNT", count.toString())
                editor.putInt("0", count)
                val text = dialogView.etNote.text.toString()
                editor.putString("$count", text)
                editor.apply()
                notes.add(dialogView.etNote.text.toString())
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }

    override fun onStart() {
        super.onStart()


        for ((k, v) in sharedPrefs.all) {
            if ((k as String) != "0") notes.add(v.toString())
        }


    }
}

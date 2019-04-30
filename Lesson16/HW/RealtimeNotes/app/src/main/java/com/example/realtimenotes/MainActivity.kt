package com.example.realtimenotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.item_row.*
import kotlinx.android.synthetic.main.login_dialog.view.*

class MainActivity : AppCompatActivity(), ChildEventListener {

    private var firebaseAuth = FirebaseAuth.getInstance()

    private lateinit var adapter: NoteAdapter

    private val notes = arrayListOf<Note>()

    private val noteDialogView by lazy {
        layoutInflater.inflate(R.layout.dialog_view, null, false)
    }

    private val loginDialogView by lazy {
        layoutInflater.inflate(R.layout.login_dialog, null, false)
    }

    private val db = FirebaseDatabase.getInstance().reference


    private val noteAlert by lazy {
        AlertDialog.Builder(this).setView(noteDialogView).setTitle("New Note").setCancelable(false)
            .setPositiveButton("Done") { dialog, _ ->
                val note = Note(
                    System.currentTimeMillis().toString(),
                    noteDialogView.etTitle.text.toString(),
                    noteDialogView.etNote.text.toString()
                )
                //code to update database
                //Log.e("DB", db.key)
                db.child(firebaseAuth.currentUser?.uid.toString()).child(note.time).setValue(note)
                Log.e("NOTE", note.title)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(true)
            .create()
    }

    private val loginAlert by lazy {
        AlertDialog.Builder(this).setView(loginDialogView)
            .setTitle("Login")
            .setPositiveButton("Sign-Up") { dialog, _ ->
                signUpWithEmailAndPass(
                    loginDialogView.etEmail.text.toString(),
                    loginDialogView.etPassword.text.toString()
                )
                dialog.dismiss()
            }
            .setNegativeButton("Sign-In") { dialog, _ ->
                signInWithEmailAndPass(
                    loginDialogView.etEmail.text.toString(),
                    loginDialogView.etPassword.text.toString()
                )
                dialog.dismiss()
            }
            .setCancelable(true)
            .create()
    }

    private fun signInWithEmailAndPass(email: String, password: String) {

        Log.e("EMAIL SIGNIN", email)

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.e("E-mail", it.user.email)
                Log.e("UID", it.user.uid)

                Toast.makeText(baseContext, "Sign-In Successful!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(baseContext, "Sign-In Failed!", Toast.LENGTH_SHORT).show()
            }
    }

    private fun signUpWithEmailAndPass(email: String, password: String) {
        Log.e("EMAIL SIGNUP", email)
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.e("E-mail", it.user.email)
                Log.e("UID", it.user.uid)

                Toast.makeText(baseContext, "Sign-Up Successful!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(baseContext, "Sign-Up Failed!", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = NoteAdapter(notes)

        rvNotes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvNotes.adapter = adapter

        firebaseAuth.addAuthStateListener {
            it.currentUser?.let {
                fab.show()
            } ?: run {
                fab.hide()
            }
        }

        var firebaseUser: FirebaseUser? = firebaseAuth.currentUser

        Log.e("AUTH", firebaseUser?.email.toString())

        fab.setOnClickListener {
            noteAlert.show()
        }

        firebaseUser?.let {

            //Attach listener to UID
            db.child(firebaseUser.uid).addChildEventListener(this)

        }

    }

    override fun onCancelled(p0: DatabaseError) {
        p0.toException().printStackTrace()
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {

    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val note = p0.getValue(Note::class.java)
        note?.let {
            notes.add(note)
        }
        adapter.notifyDataSetChanged()
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        val note = p0.getValue(Note::class.java)
        note?.let {
            notes.remove(note)
        }
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        loginAlert.show()
        return super.onOptionsItemSelected(item)
    }
}

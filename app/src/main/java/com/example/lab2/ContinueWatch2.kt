package com.example.lab2

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ContinueWatch2 : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var db: SQLiteDatabase
    private lateinit var cursor: Cursor
    private var isRunning: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continue_watch)
        try {
            val databaseHelper = DatabaseHelper(this)
            db = databaseHelper.writableDatabase
            cursor = db.query("TIME", Array(1) {"TIMER"}, null,
                    null, null, null, null)
            if (cursor.moveToFirst()) {
                val time = cursor.getInt(0)
                secondsElapsed = time
                findViewById<TextView>(R.id.textSecondsElapsed).post {
                    findViewById<TextView>(R.id.textSecondsElapsed).text =
                            String.format(getString(R.string.seconds_elapsed) + " %s", secondsElapsed)
                }
            }
            db.close()
            cursor.close()
        } catch (e: SQLiteException) {
            val toast:Toast = Toast.makeText(this, "Database Unavailable", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    override fun onResume() {
        super.onResume()
        isRunning = true
        val backgroundThread = Thread {
            while (isRunning) {
                Thread.sleep(1000)
                findViewById<TextView>(R.id.textSecondsElapsed).post {
                    findViewById<TextView>(R.id.textSecondsElapsed).text =
                            String.format(getString(R.string.seconds_elapsed) + " %s", secondsElapsed++
                            )
                }
            }
        }
        backgroundThread.start()
    }

    override fun onPause() {
        super.onPause()
        isRunning = false
    }

    override fun onDestroy() {
        super.onDestroy()
        val contentValues = ContentValues()
        contentValues.put("TIMER", secondsElapsed)
        val databaseHelper = DatabaseHelper(applicationContext)
        try {
            val db = databaseHelper.writableDatabase
            db.update("TIME", contentValues, "_id = ?",
                    Array(1) { 1.toString() })
            db.close()
            cursor.close()
        }
        catch (e: SQLiteException) {
            val toast:Toast = Toast.makeText(this, "Database Unavailable", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}
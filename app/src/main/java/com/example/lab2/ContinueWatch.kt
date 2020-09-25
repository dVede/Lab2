package com.example.lab2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContinueWatch : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private var isRunning: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continue_watch)
        findViewById<TextView>(R.id.textSecondsElapsed).post {
            findViewById<TextView>(R.id.textSecondsElapsed).text =
                    String.format(getString(R.string.seconds_elapsed) + " %s", secondsElapsed)
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
                            String.format(getString(R.string.seconds_elapsed) + " %s", secondsElapsed++)
                }
            }
        }
        backgroundThread.start()
    }

    override fun onPause() {
        super.onPause()
        isRunning = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", secondsElapsed)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        secondsElapsed = savedInstanceState.getInt("seconds")
        findViewById<TextView>(R.id.textSecondsElapsed).text =
                String.format(getString(R.string.seconds_elapsed) + " %s", secondsElapsed)
    }
}
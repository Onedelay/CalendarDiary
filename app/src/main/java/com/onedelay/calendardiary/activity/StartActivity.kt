package com.onedelay.calendardiary.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.widget.CalendarView
import android.widget.Toast
import com.onedelay.calendardiary.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        Handler().postDelayed({ startActivity(Intent(baseContext, MainActivity::class.java)); finish() }, 2000L)
    }
}
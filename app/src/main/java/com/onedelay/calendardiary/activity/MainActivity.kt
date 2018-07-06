package com.onedelay.calendardiary.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CalendarView
import android.widget.Toast
import com.onedelay.calendardiary.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar: CalendarView = findViewById(R.id.calendarView)

        calendar.viewTreeObserver.addOnGlobalLayoutListener({ Toast.makeText(baseContext, "클릭됨", Toast.LENGTH_SHORT).show() })
        calendar.setOnDateChangeListener({ calendarView, year, month, dayOfMonth -> Toast.makeText(baseContext, "클릭됨", Toast.LENGTH_SHORT).show() })
    }
}

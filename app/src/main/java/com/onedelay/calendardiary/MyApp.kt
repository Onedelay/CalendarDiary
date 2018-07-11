package com.onedelay.calendardiary

import android.app.Application
import android.arch.persistence.room.Room
import com.onedelay.calendardiary.database.MyDatabase

class MyApp : Application() {
    companion object {
        var database: MyDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        MyApp.database = Room.databaseBuilder(this, MyDatabase::class.java, "diary-db").build()
    }
}
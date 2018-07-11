package com.onedelay.calendardiary.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Diary::class), version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao
}
package com.onedelay.calendardiary.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface DiaryDao {
    @Query("SELECT * FROM diary")
    fun getAllDiary(): MutableList<Diary>

    @Insert
    fun insert(diary: Diary)
}
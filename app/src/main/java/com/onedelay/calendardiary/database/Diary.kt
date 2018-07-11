package com.onedelay.calendardiary.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Diary(
        @PrimaryKey(autoGenerate = true)
        val num: Long,
        val sticker: Int,
        val category: String = "오늘의 일기",
        val date: String = "18/07/12",
        val content: String = ""
)
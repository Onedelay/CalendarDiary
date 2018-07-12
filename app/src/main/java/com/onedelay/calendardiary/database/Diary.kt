package com.onedelay.calendardiary.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "diary")
data class Diary(
        val sticker: Int,
        val category: String = "오늘의 일기",
        val date: String = "18/07/12",
        val content: String = ""
){
    @PrimaryKey(autoGenerate = true) var num: Long? = null
}
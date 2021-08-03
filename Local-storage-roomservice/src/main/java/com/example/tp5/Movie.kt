package com.example.tp5

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "movies")
data class Movie (
    val title:String,
    val year:String,
    val language:String,
    @PrimaryKey(autoGenerate = true)
    val id_movie:Long?=0

)
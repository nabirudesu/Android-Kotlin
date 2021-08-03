package com.example.tp5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actors")
data class Actor (
        val firstname:String,
        val lastname:String,
        val gendre:String,
        @PrimaryKey(autoGenerate = true)
        val id_actor:Long?=0

)

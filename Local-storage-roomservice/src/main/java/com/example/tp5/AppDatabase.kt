package com.example.tp5

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Actor::class,Movie::class,ActorMovie::class),version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getActorDao():ActorDao
    abstract fun getMovieDao():MovieDao
    abstract fun getActorMovieDao():ActorMovieDao
}
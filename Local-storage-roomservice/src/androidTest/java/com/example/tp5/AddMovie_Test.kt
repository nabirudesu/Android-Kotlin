package com.example.tp5

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class AddMovie_Test {
    lateinit var mDataBase: AppDatabase

    @Before
    fun initDB() {
        mDataBase =
                Room.inMemoryDatabaseBuilder(
                        InstrumentationRegistry.getInstrumentation().context, AppDatabase::class.java
                ).build()
    }

    @Test
    fun testInsertAndGetUser() {
        val Movie1 = Movie( "Exam","2009","English",1)
        mDataBase?.getMovieDao()?.addMovie(Movie1)
        val list = mDataBase?.getMovieDao()?.getMoviesByTitle("Exam")
        Assert.assertEquals(Movie1, list.get(0))
    }

    @After
    fun closeDb() {
        mDataBase?.close()
    }
}
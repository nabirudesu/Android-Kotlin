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
class GetActorsMovie {
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
        val actor1 = Actor( "tuto","julio","male",1)
        mDataBase?.getActorDao()?.addActor(actor1)

        val Movie1 = Movie( "Exam","2009","English",1)
        mDataBase?.getMovieDao()?.addMovie(Movie1)

        val actormovie1 = ActorMovie(1,1)
        if (actormovie1 != null) {
            mDataBase?.getActorMovieDao()?.addActorMovie(actormovie1)
        }
        val list = mDataBase?.getActorMovieDao()?.getActorsMovie("Exam")
        Assert.assertEquals(actor1, list.get(0))
    }

    @After
    fun closeDb() {
        mDataBase?.close()
    }
}
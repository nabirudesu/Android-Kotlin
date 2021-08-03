package com.example.tp5

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AddActor_Test {
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
        val list = mDataBase?.getActorDao()?.getActorsByFirstName("tuto")
        Assert.assertEquals(actor1, list.get(0))
    }

    @After
    fun closeDb() {
        mDataBase?.close()
    }
}
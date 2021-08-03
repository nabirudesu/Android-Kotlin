package com.example.tp5

import androidx.room.*

@Dao
interface ActorDao {
    @Insert
    fun addActor(user:Actor)
    @Update
    fun updateActor(user:Actor)
    @Delete
    fun deleteActor(user:Actor)
    @Query("Select * From actors")
    fun getActors():List<Actor>
    @Query("Select * From actors Where firstName= :firstName")
    fun getActorsByFirstName(firstName:String):List<Actor>
}
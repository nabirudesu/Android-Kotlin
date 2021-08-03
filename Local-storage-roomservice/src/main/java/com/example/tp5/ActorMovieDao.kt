package com.example.tp5

import androidx.room.*

@Dao
interface ActorMovieDao {
    @Insert
    fun addActorMovie(user:ActorMovie)
    @Update
    fun updateActorMovie(user:ActorMovie)
    @Delete
    fun deleteActorMovie(user:ActorMovie)
    @Query("Select * From actor_movie")
    fun getActorsMovies():List<ActorMovie>
    @Query("Select D.* From  (Select A.* From actor_movie as A inner join (Select id_movie From movies Where title= :title)as B on A.id_movie=B.id_movie) as C inner join actors as D on C.id_actor=D.id_actor")
    fun getActorsMovie(title:String):List<Actor>
}
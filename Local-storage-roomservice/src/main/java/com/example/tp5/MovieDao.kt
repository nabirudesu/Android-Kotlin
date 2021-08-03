package com.example.tp5

import androidx.room.*

@Dao
interface MovieDao {
    @Insert
    fun addMovie(user:Movie)
    @Update
    fun updateMovie(user:Movie)
    @Delete
    fun deleteMovie(user:Movie)
    @Query("Select * From movies")
    fun getMovies():List<Movie>
    @Query("Select *From movies Where title= :title")
    fun getMoviesByTitle(title:String):List<Movie>
}
package com.example.tp7

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {

    @GET("getMoveisNames")
    fun getMoveisNames():Call<List<Movie>>

    @GET("getactorsbymovie/{title}")
    fun getactorsbymovie(@Path("title") title:String):Call<List<Actor>>
    @POST("addactor")
    fun addactor(@Body user:Actor):Call<String>

}
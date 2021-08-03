package com.example.tp7

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitService {
    val endpoint :Endpoint by lazy {
        Retrofit.Builder().baseUrl("https://4c2e718b26ac.ngrok.io").
        addConverterFactory(GsonConverterFactory.create()).
        build().create(Endpoint::class.java)
    }
}
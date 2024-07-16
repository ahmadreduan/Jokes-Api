package com.quantumquestlabs.jokesapi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokesApiService {

    @GET("joke/Programming")
    suspend fun getJokes():Response<ResponseJokes>



}

object  JokesClient{
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://v2.jokeapi.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val jokesApiService = retrofit.create(JokesApiService::class.java)

}
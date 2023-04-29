package com.example.apiconsumoapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface jokeService {
    @GET("api")
    fun getJoke(@Query("format") format:String): Call<Joke>

}
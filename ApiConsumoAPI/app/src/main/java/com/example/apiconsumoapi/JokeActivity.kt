package com.example.apiconsumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        val btn_joke = findViewById<Button>(R.id.btnJoke)
        btn_joke.setOnClickListener {
            loadJoke()
        }
    }

    private fun loadJoke() {
        val tv_broma = findViewById<TextView>(R.id.textView)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create() )
            .build()
        val joke_Service : jokeService
        joke_Service = retrofit.create(jokeService::class.java)
         val request = joke_Service.getJoke("json")
        request.enqueue(object : Callback<Joke>{
            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.d("jokeActitvity", t.toString())
            }

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful){
                    tv_broma.text=response.body()!!.joke
                }
            }
        })
        //tv_broma.text ="Broma encontrada!!!"
    }
}
package com.tekprosft.starwardemo.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apis {
    fun getStarWarApi(): Swapi {
        val gson = GsonBuilder ().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return  retrofit.create(Swapi::class.java)
    }
}
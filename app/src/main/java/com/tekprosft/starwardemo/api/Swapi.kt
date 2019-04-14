package com.tekprosft.starwardemo.api

import com.tekprosft.starwardemo.api.response.SpeciesResponse
import retrofit2.Call
import retrofit2.http.GET

interface Swapi {
    @GET("species/")
    fun getSpecies(): Call<SpeciesResponse>
}
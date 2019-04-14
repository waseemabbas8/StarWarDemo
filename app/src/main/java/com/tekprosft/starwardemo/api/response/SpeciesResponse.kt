package com.tekprosft.starwardemo.api.response

import com.google.gson.annotations.SerializedName

data class SpeciesResponse(
    val count: Int,
    val next: String,
    val previous: String,

    @SerializedName("results")
    val species: List<Specie>
)
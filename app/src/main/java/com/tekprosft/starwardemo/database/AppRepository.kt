package com.tekprosft.starwardemo.database

import com.tekprosft.starwardemo.api.Apis
import com.tekprosft.starwardemo.api.response.SpeciesResponse

class AppRepository {

    private val apiService = Apis.getStarWarApi()

    fun getAllSpecies(): RetrofitLiveData<SpeciesResponse> = RetrofitLiveData(apiService.getSpecies())

    companion object {
        private lateinit var sInstance : AppRepository

        @JvmStatic
        fun getInstance() : AppRepository{
            if (!::sInstance.isInitialized){
                sInstance = AppRepository()
            }
            return sInstance
        }

    }
}
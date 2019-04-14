package com.tekprosft.starwardemo.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tekprosft.starwardemo.api.response.SpeciesResponse
import com.tekprosft.starwardemo.database.AppRepository
import com.tekprosft.starwardemo.database.RetrofitLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val mSpecies : RetrofitLiveData<SpeciesResponse>
    private val mRepository : AppRepository

    init {
        mRepository = AppRepository.getInstance()
        mSpecies = mRepository.getAllSpecies()
    }

    override fun onCleared() {
        mSpecies.cancel()
    }
}
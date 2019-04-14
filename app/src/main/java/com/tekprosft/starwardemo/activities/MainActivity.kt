package com.tekprosft.starwardemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tekprosft.starwardemo.R
import com.tekprosft.starwardemo.adapters.SpeciesAdapter
import com.tekprosft.starwardemo.api.response.Specie
import com.tekprosft.starwardemo.api.response.SpeciesResponse
import com.tekprosft.starwardemo.utils.MyViewBinder.Companion.bind
import com.tekprosft.starwardemo.viewmodels.MainViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val mRecyclerView : RecyclerView by bind(R.id.rv_species)
    private lateinit var mViewModel : MainViewModel
    private var mAdapter : SpeciesAdapter? = null
    private val speciesData = ArrayList<Specie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView() {
        mRecyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        mRecyclerView.layoutManager = layoutManager
    }

    private fun initViewModel() {
        val mObserver = Observer<SpeciesResponse>{
            speciesData.clear()
            speciesData.addAll(it.species)

            if (mAdapter == null){
                mAdapter = SpeciesAdapter(speciesData)
                mRecyclerView.adapter = mAdapter
            }else{
                mAdapter!!.notifyDataSetChanged()
            }
        }

        mViewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)
        mViewModel.mSpecies.observe(this@MainActivity, mObserver)
    }


}

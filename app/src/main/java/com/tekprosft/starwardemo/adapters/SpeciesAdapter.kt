package com.tekprosft.starwardemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tekprosft.starwardemo.R
import com.tekprosft.starwardemo.api.response.Specie

class SpeciesAdapter(private val mSpecies: ArrayList<Specie>) : RecyclerView.Adapter<SpeciesAdapter.SpeciesVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesVH {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_species_list, parent, false)
        return SpeciesVH(view)
    }

    override fun getItemCount(): Int {
        return mSpecies.size
    }

    override fun onBindViewHolder(holder: SpeciesVH, position: Int) {
        holder.mName.text = mSpecies[position].name
        holder.mClassification.text = mSpecies[position].classification
        holder.mLanguage.text = mSpecies[position].language
        holder.mLifeSpan.text = mSpecies[position].averageLifespan
    }

    class SpeciesVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mName: TextView = itemView.findViewById(R.id.name)
        val mClassification: TextView = itemView.findViewById(R.id.classification)
        val mLanguage: TextView = itemView.findViewById(R.id.language)
        val mLifeSpan: TextView = itemView.findViewById(R.id.lifeSpan)
    }
}
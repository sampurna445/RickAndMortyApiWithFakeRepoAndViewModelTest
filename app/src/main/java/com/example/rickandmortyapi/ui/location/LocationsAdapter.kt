package com.example.rickandmortyapi.ui.location

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.data.model.location.ResultModel
import com.example.rickandmortyapi.databinding.ItemCharactersBinding
import com.example.rickandmortyapi.databinding.ItemLoactionBinding
import com.example.rickandmortyapi.ui.characters.CharactersAdapter

class LocationsAdapter(var locations: List<ResultModel?>?) :
    RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {
    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemLoactionBinding.bind(view)

        fun handleData(item: com.example.rickandmortyapi.data.model.location.ResultModel?) {
           binding.locationName.text = item?.name
            binding.locationType.text = item?.type


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_loaction, parent, false)
        return LocationsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int  = locations?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(locations?.get(position))
    }

}

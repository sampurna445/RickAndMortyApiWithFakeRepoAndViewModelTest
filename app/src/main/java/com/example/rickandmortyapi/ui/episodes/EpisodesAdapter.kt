package com.example.rickandmortyapi.ui.episodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.data.model.episodes.ResultModel
import com.example.rickandmortyapi.databinding.ItemCharactersBinding
import com.example.rickandmortyapi.databinding.ItemEpisodesBinding
import com.example.rickandmortyapi.ui.characters.CharactersAdapter

class EpisodesAdapter(var episodes: List<ResultModel?>?) :
    RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {
    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemEpisodesBinding.bind(view)

        fun handleData(item: com.example.rickandmortyapi.data.model.episodes.ResultModel?) {
           binding.headingEpisode.text = item?.episode
            binding.episodeDate.text = item?.airDate


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_episodes, parent, false)
        return EpisodesAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int  = episodes?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(episodes?.get(position))
    }

}

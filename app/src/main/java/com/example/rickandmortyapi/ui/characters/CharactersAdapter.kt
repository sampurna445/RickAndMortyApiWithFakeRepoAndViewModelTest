package com.example.rickandmortyapi.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.databinding.ItemCharactersBinding

class CharactersAdapter(var characters: List<ResultModel?>?) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var onItemClick: ((ResultModel) -> Unit)? = null

    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemCharactersBinding.bind(view)

        fun handleData(item: com.example.rickandmortyapi.data.model.characters.ResultModel?) {
            binding.itemName.text = item?.name
            binding.itemStatus.text = item?.status
            binding.imgCharacter.load(item?.image)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false)
        return CharactersAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int  = characters?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val charItemModel = characters?.get(position)
        holder.handleData(charItemModel!!)
        holder?.itemView?.setOnClickListener {
            characters?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    fun setFilteredList(list: ArrayList<ResultModel>) {
        characters = list
        notifyDataSetChanged()
    }

}

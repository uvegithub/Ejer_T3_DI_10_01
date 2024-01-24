package com.example.ejer_t3_di_10_01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer_t3_di_10_01.databinding.ItemDigimonBinding
import com.example.ejer_t3_di_10_01.databinding.ItemPiezaBinding

class DigimonAdapter(var lista_digimons: MutableList<Digimon>, private val listener: OnClickListener) : RecyclerView.Adapter<DigimonAdapter.Viewholder>(){

    inner class Viewholder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemDigimonBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_digimon, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return lista_digimons.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val digimon = lista_digimons.get(position)
        holder.binding.itemNombreDigimon.text= digimon.nombre_digimon
    }

    fun anadirDigimon(digimon:Digimon){
        lista_digimons.add(digimon)
        notifyDataSetChanged()
    }

    fun borrarDigimon(digimon:Digimon){
        lista_digimons.remove(digimon)
        notifyDataSetChanged()
    }

}
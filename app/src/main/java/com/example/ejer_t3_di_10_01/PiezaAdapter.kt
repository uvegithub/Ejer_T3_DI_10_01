package com.example.ejer_t3_di_10_01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer_t3_di_10_01.databinding.ItemPiezaBinding

class PiezaAdapter(var lista_piezas: MutableList<Pieza>, private val listener: OnClickListener) : RecyclerView.Adapter<PiezaAdapter.Viewholder>(){

    inner class Viewholder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemPiezaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pieza, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return lista_piezas.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val pieza = lista_piezas.get(position)
        holder.binding.nombre.text = pieza.nombre_pieza
        holder.binding.foto.setImageDrawable(pieza.imagen)
//        holder.binding.foto.setImageDrawable(Drawable.createFromPath(R.drawable.foto_redonda.toString())!!)
    }
}
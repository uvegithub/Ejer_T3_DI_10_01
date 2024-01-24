package com.example.ejer_t3_di_10_01

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer_t3_di_10_01.databinding.ItemDigimonBinding
import com.example.ejer_t3_di_10_01.databinding.ItemDigimonEjer4Binding

class DigimonAdapterEjer4 (var listadigimon: MutableList<Digimon4>, private val listener: OnClickListener) : RecyclerView.Adapter<DigimonAdapterEjer4.ViewHolder>(){
    //un viewholder es una clase que se encarga de mantener los elementos de la lista en memoria
    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemDigimonEjer4Binding.bind(view) //esto es para poder acceder a los elementos del layout

        fun setListener(digimon: Digimon4) {
            binding.root.setOnLongClickListener {
                listener.onLongClick(digimon)
                true

            }
        }

    }

    //este metodo se ejecuta cuando se crea el viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //aqui inflamos el layout que hemos creado para cada elemento de la lista
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_digimon_ejer4, parent, false)

        //aqui creamos el viewholder y le pasamos la vista que acabamos de inflar para luego devolverlo
        return ViewHolder(view)

    }

    //este metodo nos indica cuantos elementos tiene la lista
    override fun getItemCount(): Int = listadigimon.size



    //este metodo se ejecuta cuando se quiere mostrar un elemento de la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //le daremos valores a los elementos de cada item de la lista
        //en este caso solo tenemos un textview que será el nombre del pokemon
        val digimon = listadigimon.get(position)

        holder.setListener(digimon)

        holder.binding.tvDigimon.text = digimon.nombre
        holder.binding.checkNombreDigimon.isChecked = digimon.evolucionado


        holder.binding.checkNombreDigimon.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                digimon.evolucionado = true
                listener.onDigimonEvolucionado(digimon)
            } else {
                digimon.evolucionado = false
                listener.onDigimonDesEvolucionado(digimon)
            }
        }
    }

    fun addDigimon(digimon: Digimon4) {
        listadigimon.add(digimon)
        notifyDataSetChanged()
    }

    fun removeDigimon(digimon: Digimon4) {
        listadigimon.remove(digimon)
        notifyDataSetChanged() //este metodo es para que se actualice la lista
    }

}
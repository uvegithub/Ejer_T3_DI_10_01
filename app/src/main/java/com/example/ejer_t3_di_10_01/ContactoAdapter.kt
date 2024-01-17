package com.example.ejer_t3_di_10_01

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer_t3_di_10_01.databinding.ItemContactoBinding

class ContactoAdapter (var lista_contactos: MutableList<Contacto>, private val listener: OnClickListener) : RecyclerView.Adapter<ContactoAdapter.Viewholder>(){

    inner class Viewholder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemContactoBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return lista_contactos.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val contacto = lista_contactos.get(position)
        holder.binding.nombre.text = contacto.nombre
        holder.binding.foto.setImageDrawable(contacto.foto)
        holder.binding.email.text = contacto.correo
        holder.binding.numero.text = contacto.telefono.toString()
//        holder.binding.foto.setImageDrawable(Drawable.createFromPath(R.drawable.foto_redonda.toString())!!)
    }
}
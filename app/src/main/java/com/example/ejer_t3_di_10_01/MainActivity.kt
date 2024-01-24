package com.example.ejer_t3_di_10_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer_t3_di_10_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contactoAdapter: ContactoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = mutableListOf(
            Contacto(getDrawable(R.drawable.foto_redonda)!!, "Lucia", 611111, "lu@gmail.com")!!,
            Contacto(getDrawable(R.drawable.foto_redonda2)!!, "María", 622222, "ma@gmail.com")!!,
            Contacto(getDrawable(R.drawable.foto_redonda3)!!, "Teresa", 633333, "te@gmail.com")!!,
            Contacto(getDrawable(R.drawable.foto_redonda4)!!, "Valentina", 644444, "va@gmail.com")!!
        )

        contactoAdapter = ContactoAdapter(data, this)

       binding.recycler.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = contactoAdapter
        }
    }

    override fun onDigimonDesEvolucionado(digimon: Digimon4) {
        TODO("Not yet implemented")
    }

    override fun onLongClick(contacto: Contacto) {

    }

    fun iniciarActividadEjercicio2 (view : View){
        val intent = Intent(this, Ejercicio_2::class.java)
        startActivity(intent)
    }

    override fun onLongClick(digimon: Digimon4){

    } //funcion que se ejecuta cuando se hace click largo en un elemento de la lista
    override fun onDigimonEvolucionado(digimon: Digimon4){

    }
}
package com.example.ejer_t3_di_10_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejer_t3_di_10_01.databinding.ActivityEjercicio3Binding

class Ejercicio_3 : AppCompatActivity(), OnClickListener {

    private lateinit var bAnadir: ImageView
    private lateinit var bEliminar: ImageView

    private lateinit var binding: ActivityEjercicio3Binding
    private lateinit var digimonAdapter: DigimonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        bAnadir=findViewById(R.id.item_anadir)
        bEliminar=findViewById(R.id.item_borrar)

        val data = mutableListOf(
            Digimon("angemon")!!,
        )

        digimonAdapter = DigimonAdapter(data, this)

        binding.recycler.apply{
            layoutManager = LinearLayoutManager(this@Ejercicio_3)
            adapter = digimonAdapter
        }

        bAnadir.setOnClickListener{
            if(binding.etDigimon.text.toString().isNotEmpty()){
                val digimon = Digimon(binding.etDigimon.text.toString())

                anadirDigimonAutomaticamente(digimon)

                binding.etDigimon.text?.clear()
            }
        }

        bEliminar.setOnClickListener{
            if(binding.etDigimon.text.toString().isNotEmpty()){
                val digimon = Digimon(binding.etDigimon.text.toString())

                borrarDigimonAutomaticamente(digimon)

                binding.etDigimon.text?.clear()
            }
        }
    }

    private fun anadirDigimonAutomaticamente(digimon: Digimon){
        digimonAdapter.anadirDigimon(digimon)
    }

    private fun borrarDigimonAutomaticamente(digimon: Digimon){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Eliminar digimon")
        builder.setMessage("¿Estás seguro de que deseas eliminar a ${digimon.nombre_digimon}?")
        builder.setPositiveButton("Sí"){_, _ ->
            digimonAdapter.borrarDigimon(digimon)}
        builder.setNegativeButton("No") { _, _ ->
        }
        builder.show()
    }


    fun iniciarActividadEjercicio4 (view : View){
        val intent = Intent(this, Ejercicio_4::class.java)
        startActivity(intent)
    }

    override fun onLongClick(contacto: Contacto) {

    }

}
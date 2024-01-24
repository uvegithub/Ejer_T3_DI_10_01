package com.example.ejer_t3_di_10_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejer_t3_di_10_01.databinding.ActivityEjercicio4Binding

class Ejercicio_4 : AppCompatActivity(), OnClickListener {

    private lateinit var bAnadir: ImageView
    private lateinit var bEliminar: ImageView

    private lateinit var binding: ActivityEjercicio4Binding
    private lateinit var digimonAdapter: DigimonAdapterEjer4

    private lateinit var evolucionadosAdapter: DigimonAdapterEjer4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        bAnadir=findViewById(R.id.item_anadir)
        bEliminar=findViewById(R.id.item_borrar)

        //al adaptador hay que pasarle la lista de datos y el listener
        digimonAdapter = DigimonAdapterEjer4(mutableListOf(), this) //this es el listener
        evolucionadosAdapter = DigimonAdapterEjer4(mutableListOf(), this)

        binding.recycler.apply { //aqui le decimos al recyclerview que use el adaptador que hemos creado
            layoutManager = LinearLayoutManager(this@Ejercicio_4) //esto es para que el recyclerview se muestre como una lista
            adapter = digimonAdapter
        }

        //añadimo es nuevo adapter
        binding.recycler2.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio_4)
            adapter = evolucionadosAdapter
        }

        bAnadir.setOnClickListener {
            if(binding.etDigimon.text.toString().isNotEmpty()){
                val digimon = Digimon4(binding.etDigimon.text.toString())

                addDigimonAutomatically(digimon)

                binding.etDigimon.text?.clear()


            }
        }

    }

    private fun getData(){
        val data = mutableListOf(
            Digimon4("angemon", true),
            Digimon4("demomon", true),
            )

        data.forEach {digimon ->
            addDigimonAutomatically(digimon)
        }

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun addDigimonAutomatically(digimon: Digimon4) {

        //si por ejemplo el nombre del pokemon es pikachu o tiene la 'a', lo añadimos al segundo adaptador
        if (digimon.evolucionado == true) {
            evolucionadosAdapter.addDigimon(digimon)
        }else{
            digimonAdapter.addDigimon(digimon)
        }

    }

    override fun onDigimonEvolucionado(digimon: Digimon4) {
        digimonAdapter.removeDigimon(digimon)
        evolucionadosAdapter.addDigimon(digimon)
    }
//    override fun onPokemonReleased(pokemon: Pokemon) {
//        capturadosAdapter.removePokemon(pokemon)
//        pokemonAdapter.addPokemon(pokemon)
//    }

    //sobrecargamos el metodo onLongClick de la interfaz OnClickListener
    override fun onLongClick(digimon: Digimon4) {
        //aqui se ejecuta el codigo cuando se hace click largo en un elemento de la lista

        removeDigimonAutomatically(digimon)

    }

    private fun removeDigimonAutomatically(digimon: Digimon4) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar Pokemon")
        builder.setMessage("¿Estas seguro de que quieres eliminar a ${digimon.nombre}?")
        builder.setPositiveButton("Si") { _, _ ->
            digimonAdapter.addDigimon(digimon)
            evolucionadosAdapter.removeDigimon(digimon)
        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.show()


    }

    override fun onLongClick(contacto: Contacto) {

    }

    override fun onDigimonDesEvolucionado(digimon: Digimon4) {
        digimonAdapter.addDigimon(digimon)
        evolucionadosAdapter.removeDigimon(digimon)
    }
}
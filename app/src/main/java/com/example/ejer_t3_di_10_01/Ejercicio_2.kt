package com.example.ejer_t3_di_10_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejer_t3_di_10_01.databinding.ActivityEjercicio2Binding

class Ejercicio_2 : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityEjercicio2Binding
    private lateinit var piezaAdapter: PiezaAdapter

//    private lateinit var bEjer3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        bEjer3=findViewById(R.id.boton_ejer2)

        val data = mutableListOf(
            Pieza(getDrawable(R.drawable.p_peon)!!, "peon")!!,
            Pieza(getDrawable(R.drawable.p_torre)!!, "torre")!!,
            Pieza(getDrawable(R.drawable.p_caballo)!!, "caballo")!!,
            Pieza(getDrawable(R.drawable.p_alfil)!!, "alfil")!!,
            Pieza(getDrawable(R.drawable.p_rey)!!, "rey")!!,
            Pieza(getDrawable(R.drawable.p_reina)!!, "reina")!!,
        )

        piezaAdapter = PiezaAdapter(data, this)

        binding.recycler.apply{
            layoutManager = LinearLayoutManager(this@Ejercicio_2, LinearLayoutManager.HORIZONTAL, false)
            adapter = piezaAdapter
        }

        binding.botonEjer3.setOnClickListener {
            val intent = Intent(this, Ejercicio_3::class.java)
            startActivity(intent)
        }
    }


//    fun iniciarActividadEjercicio3 (view : View){
//        val intent = Intent(this, Ejercicio_3::class.java)
//        startActivity(intent)
//    }

    override fun onLongClick(contacto: Contacto) {

    }

    override fun onLongClick(digimon: Digimon4) {
        TODO("Not yet implemented")
    }

    override fun onDigimonEvolucionado(digimon: Digimon4) {
        TODO("Not yet implemented")
    }

    override fun onDigimonDesEvolucionado(digimon: Digimon4) {
        TODO("Not yet implemented")
    }
}
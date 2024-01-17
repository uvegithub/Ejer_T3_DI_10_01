package com.example.ejer_t3_di_10_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.ejer_t3_di_10_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonAdapter: ContactoAdapter

    private lateinit var imagen01: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = mutableListOf(
            Contacto(getDrawable(R.drawable.foto_redonda)!!, "Lucia", 11111, "lu@gmail.com")!! ,
        )

    }
}
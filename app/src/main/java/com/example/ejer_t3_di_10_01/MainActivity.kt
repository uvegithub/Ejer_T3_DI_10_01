package com.example.ejer_t3_di_10_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejer_t3_di_10_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonAdapter: ContactoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
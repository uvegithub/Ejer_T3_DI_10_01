package com.example.ejer_t3_di_10_01

import android.graphics.drawable.Drawable

data class Pieza(val imagen: Drawable = Drawable.createFromPath(R.drawable.foto_redonda.toString())!!, val nombre_pieza: String = "peon")
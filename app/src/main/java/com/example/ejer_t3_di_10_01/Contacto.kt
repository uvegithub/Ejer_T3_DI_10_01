package com.example.ejer_t3_di_10_01

import android.graphics.drawable.Drawable

data class Contacto(val foto: Drawable = Drawable.createFromPath(R.drawable.foto_redonda.toString())!!, val nombre: String = "Lucia", val telefono: Int = 111111, val correo: String = "a@gmail.com")

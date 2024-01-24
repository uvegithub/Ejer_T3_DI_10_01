package com.example.ejer_t3_di_10_01

interface OnClickListener {

    fun onLongClick(contacto: Contacto)

    fun onLongClick(digimon: Digimon4) //funcion que se ejecuta cuando se hace click largo en un elemento de la lista
    fun onDigimonEvolucionado(digimon: Digimon4)

    fun onDigimonDesEvolucionado(digimon: Digimon4)


}


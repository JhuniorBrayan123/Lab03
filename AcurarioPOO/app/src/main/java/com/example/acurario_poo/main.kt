package com.example.acurario_poo

fun construirAcuario() {
    val acuarioSecundario = Acuario(200)
    println("Acuario creado con constructor secundario:")
    acuarioSecundario.mostrarDatos()
}

fun crearPeces() {
    val tiburon = Tiburon()
    val pezPayaso = PezPayaso()

    println("El tiburon es de color: ${tiburon.color}")
    tiburon.comer()
    println("El pez payaso es de color: ${pezPayaso.color}")
    pezPayaso.comer()
}

fun main() {
    construirAcuario()
    println("------")
    crearPeces()
}

package com.example.acurario_poo

abstract class Pez{
    abstract val color: String
}

//Ahora nuestra clase que hereda
class Tiburon: Pez(),AccionPez{
    override val color: String = "gris"
    override fun comer() {
        println("El tiburon se alimenta de : Cazar y comer peces")
    }

}
//tambien creamos otra clase
class PezPayaso: Pez(), AccionPez{
    override val color: String = "dorado"
    override fun comer() {
        println("El pez payaso se alimenta de: comer las algas")
    }
}
//esta es nuestra interfaz
interface AccionPez{
    fun comer()
}
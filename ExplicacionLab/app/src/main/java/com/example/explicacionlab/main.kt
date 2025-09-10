package acuario

// --------------------
// Clase Acuario
// --------------------
open class Acuario(open var largo: Int = 100, open var ancho: Int = 20, open var alto: Int = 40) {

    init {
        println("Inicializando acuario...")
    }

    // Forma del acuario
    open val forma = "rectángulo"

    // Volumen calculado en litros (1000 cm^3 = 1 litro)
    open var volumen: Int
        get() = ancho * alto * largo / 1000
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    // Agua disponible (90% del volumen)
    open var agua: Double = 0.0
        get() = volumen * 0.9

    // Constructor secundario (para calcular alto según número de peces)
    constructor(numeroDePeces: Int) : this() {
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    fun imprimirTamano() {
        println("Forma: $forma")
        println("Dimensiones: $largo cm x $ancho cm x $alto cm")
        println("Volumen: $volumen L, Agua disponible: $agua L (${agua/volumen*100.0}% lleno)")
    }

    fun mostrarDatos() {
        println("Mostrando datos del acuario...")
        imprimirTamano()
        println("-----------")
    }
}

// --------------------
// Clase abstracta Pez
// --------------------
abstract class Pez {
    abstract val color: String
}

// --------------------
// Interfaz AccionPez
// --------------------
interface AccionPez {
    fun comer()
}

// --------------------
// Clases hijas
// --------------------
class Tiburon : Pez(), AccionPez {
    override val color = "gris"
    override fun comer() {
        println("El tiburón caza y come peces.")
    }
}

class PezPayaso : Pez(), AccionPez {
    override val color = "dorado"
    override fun comer() {
        println("El pez payaso come algas.")
    }
}

// --------------------
// Funciones principales
// --------------------
fun construirAcuarios() {
    println("== Construcción de acuarios ==")
    val acuario1 = Acuario()
    acuario1.mostrarDatos()

    val acuario2 = Acuario(10)
    println("Acuario para 10 peces:")
    acuario2.mostrarDatos()

    println("Cambiando volumen del primer acuario a 250 L...")
    acuario1.volumen = 250
    acuario1.mostrarDatos()
}

fun crearPeces() {
    println("== Creación de peces ==")
    val tiburon = Tiburon()
    val pezPayaso = PezPayaso()

    println("El tiburón es de color: ${tiburon.color}")
    tiburon.comer()

    println("El pez payaso es de color: ${pezPayaso.color}")
    pezPayaso.comer()
}

// --------------------
// main
// --------------------
fun main() {
    construirAcuarios()
    crearPeces()
}

package com.example.fundamentoskot

import java.lang.Math.abs

fun main() {
    diHola()
    newTopic("DesdeFun")
    val a = 2
    val b = 3

    println("La suma de $a + $b es igual a ${sum(a, b)}")
    println("La resta de $a - $b es igual a ${res(a, b)}")

    newTopic("Infix")
    val c = -3
    println(c.enableAbs(false))
    println()
    //Se puede declarar que simplemente queremos acceder a ciertos parametros haciendo la invocacion antes o especificandole que parametro
    newTopic("Sobrecarga")
    mostrarProducto("Auto", "20%", "20 de agosto")
    mostrarProducto("Pan")
    mostrarProducto("juguete", vigencia = "Hasta mañana")
}

//Unit == void
private fun diHola(): Unit {
    println("Hola KT")
}

fun sum(a: Int, b: Int) = a + b

fun res(a: Int, b: Int) = a - b


infix fun Int.enableAbs(enable: Boolean) = if (enable) abs(this) else this

fun mostrarProducto(name: String, promo:String = "0% de Promocion", vigencia: String = "Agotar existencias"){
    println("$name tiene el $promo hasta $vigencia")
}

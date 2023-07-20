package com.example.fundamentoskot.clases
//La palabra open es para iniciar que una clase vaya a heredar a otras clases
open class Phone(protected val number: Long){

    fun call() {
        println("llamando...")
    }
    //Tambien open para sobreescritura de metodo
    open fun showNumber(){
        println("El numero es $number")
    }
}
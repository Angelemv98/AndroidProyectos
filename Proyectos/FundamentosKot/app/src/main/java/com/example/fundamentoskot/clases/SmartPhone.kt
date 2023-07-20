package com.example.fundamentoskot.clases

class SmartPhone(number: Long, val isPrivate: Boolean): Phone(number){

    override fun showNumber(){
     if (isPrivate) println("Desconocido") else super.showNumber()
    }

}
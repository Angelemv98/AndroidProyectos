package com.example.fundamentoskot.clases

import android.R
import com.example.fundamentoskot.newTopic

fun main() {
    newTopic("Clases")
    val phone = Phone(5523022106)
    phone.call()
    phone.showNumber()
    // println(phone.number)

    newTopic("Herencia")
    val smartPhone = SmartPhone(5645454521, true)
    smartPhone.call()
    newTopic("Sobreescritura")
    smartPhone.showNumber()
    println("Es Privado?  ${smartPhone.isPrivate}")

    newTopic("Data classes")
    val myUser = User(123123, "Angel", "Morales", Group.FAMILY.ordinal)
    val bro = myUser.copy(id = 1, name = "Juan")
    val friend = bro.copy(id = 2, group = Group.FRIENDS.ordinal)
    println(myUser.component3())
    println (myUser)
    println(bro)
    println(friend)

    newTopic("funciones de alcance")
    with(smartPhone){
        println("Es privado? $isPrivate")
        call()
    }
//    friend.group = Group.WORK.ordinal
//    friend.name = "Pedro"
//    friend.lastName = "Fernandez"
    friend.apply {
        group = Group.WORK.ordinal
        friend.name = "Pedro"
        friend.lastName = "Fernandez"
    }
    println(friend)
}
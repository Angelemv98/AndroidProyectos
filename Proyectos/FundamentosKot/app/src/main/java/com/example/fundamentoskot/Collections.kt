package com.example.fundamentoskot

import com.example.fundamentoskot.clases.Group
import com.example.fundamentoskot.clases.User

fun main(){
    newTopic("Colecciones")
    newTopic("Solo lectura")
    //Creacion de un arraylist no mutable
    val frutaList = listOf("Manzana", "Platano", "Uva", "Limon")
    //Extraccion de un elemento random en base a su numero en el index
    println(frutaList.get((0..frutaList.size-1).random()))
    //Extraccion de un elemento en base al valor
    println("El index de Uva es.. ${frutaList.indexOf("Uva")}")

    //Coleccion mutable
    newTopic("Coleccion mutable")
    val myUser = User(123123, "Angel", "Morales", Group.FAMILY.ordinal)
    val bro = myUser.copy(id = 1, name = "Juan")
    val friend = bro.copy(id = 2, group = Group.FRIENDS.ordinal)
    val userList = mutableListOf(myUser,bro)
    println(userList)
    userList.add(friend)
    println(userList)
    //userList.removeAt(1)
    userList.remove(bro)
    println(userList)


    val userSelectedList = mutableListOf<User>()
    println(userSelectedList)
    //userSelectedList.addAll(userList)
    userSelectedList.add(myUser)
    println(userSelectedList)
    userSelectedList[0] = bro
    println(userSelectedList)
    userSelectedList.add(myUser)
    userSelectedList.add(myUser)
    println(userSelectedList)

    //Diccionarios, en este no puede duplicar el valor de la llave, pero los valores si
    newTopic("Map o diccionarios")
    val usersMap = mutableMapOf<Int, User>()
    println(usersMap)
    //Se hace la insercion de los dos elementos de my user pero con el mismo key
    usersMap.put(myUser.id.toInt(),myUser)
    usersMap.put(myUser.id.toInt(),myUser)
    println(usersMap)
    //Se ingresa el bro
    usersMap.put(bro.id.toInt(),bro)
    println(usersMap)
    //Se remueve con el id del bro
    usersMap.remove(bro.id.toInt())
    println(usersMap)
    //Se pregunta si esta vacio lo cual retorna un booleano
    println(usersMap.isEmpty())
    //Se pregunta que si contiene el key de usuario, lo cual retorna en booleano
    println(usersMap.contains(myUser.id.toInt()))
    usersMap.put(bro.id.toInt(),bro)
    usersMap.put(friend.id.toInt(),friend)
    println(usersMap)
    println(usersMap.keys)
    println(usersMap.values)

}
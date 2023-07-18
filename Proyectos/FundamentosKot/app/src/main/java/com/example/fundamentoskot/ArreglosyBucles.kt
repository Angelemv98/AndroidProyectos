package com.example.fundamentoskot

fun main() {
    newTopic("Bucles")
    showPersons("angel", "ernesto", "derian")
    showPersons("angel", "ernesto", "derian", "tania", "Martin")

}

fun showPersons(p1: String, p2: String, p3: String) {
    println(p1)
    println(p2)
    println(p3)
}
//Ejemplo de bucles
fun showPersons(vararg persons: String) {
    newTopic("cicloFOR")
    for (person in persons)
        println(person)
    newTopic("Ciclo while")
    var index = 0
    while (index < persons.size) {
        if (persons[index]=="tania") println("Aqui esta tania")
        println(persons[index])
        index++
    }
    newTopic("when")
}

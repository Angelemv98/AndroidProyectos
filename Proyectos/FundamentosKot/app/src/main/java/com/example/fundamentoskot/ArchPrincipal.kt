package com.example.fundamentoskot

fun main() {
    newTopic("Repaso de prints")


    newTopic("variables y constantes")
    //Nada mas basta con iniciarla para que detecte que tipo de variable es
    val const1 = 1;
    newTopic("La constante const1 tiene el valor de $const1")

    var variable = "Esto es una variable ahora traigo esto antes de sobreescribir"
    newTopic(variable);
    variable = "Ahora tengo esto "
    newTopic(variable)

    //Para que un objeto sea nullo puede agregar el signo de pregunta al inicio,
    // y tambien puede iniciar con Any para que inicie como variable que puede mutar su tipo despues
    var objNull: Any? = null
    println(objNull)



}

fun newTopic(topic: String) {
    print("\n ===================== $topic ==================== \n")
}
package com.example.sharedpreferenceusers


data class User(val id: Long, var name:String, var lastName:String, var url:String) {
    fun getfullName(): String = "$name $lastName"
}
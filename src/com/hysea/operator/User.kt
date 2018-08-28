package com.hysea.operator

data class User(var name: String, var age: Int) {
    fun say(message: String?) = message
}
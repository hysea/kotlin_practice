package com.hysea.test

import com.hysea.basic.`object`.User
import com.hysea.singleton.kotlin.Config1
import com.hysea.singleton.kotlin.Person

fun main(args: Array<String>) {
    println("hello kotlin")

    testSingleton()

    testObject()

}

fun testSingleton() {
    println(Config1) // com.hysea.singleton.kotlin.Config1@511d50c0
    println(Config1) // com.hysea.singleton.kotlin.Config1@511d50c0
    println(Config1.message())

    val hysea = Person
    val hysealive = Person

    hysea.name = "hysea"
    hysealive.name = "hysealive"
    println(hysea.name) // hysealive
    println(hysealive.name) // hysealive
}

fun testObject() {
    val newSubscribeUser = User.newSubscribeUser("hysea@163.com")
    println(newSubscribeUser.nickname)

    val newFecebookUser = User.newFecebookUser(12)
    println(newFecebookUser.nickname)
}
package com.hysea.basic.lazy

class Lazy {
    lateinit var name: String

    val message by lazy {
        println("by lazy init") // 只会执行一次
        "by lazy message"
    }
}

fun main(args: Array<String>) {
    val lazy = Lazy()
//    println(lazy.name) // kotlin.UninitializedPropertyAccessException: lateinit property name has not been initialized

    lazy.name = "lateinit init"
    println(lazy.name)
    println(lazy.message)
    println(lazy.message)

    /**
     * 打印结果为：
     * lateinit init
     * by lazy init
     * by lazy message
     * by lazy message
     */
}
package com.hysea.operator

fun main(args: Array<String>) {

    // run：用this代表当前引用对象，并且调用方法时，this可省略
    // 返回值是语句块的最后一行，若最后一行语句无返回值，则整个run语句块也无返回值
//    public inline fun <T, R> T.run(block: T.() -> R): R = block()
    val user = User("hysea", 25)
    val runResult = user.run {
        // 无it参数，this代表当前对象，可省略
        this.name = "run"
        age = 20
        say("run")
    }
    println(user)
    println(runResult) // run


    // with：与run方法感觉并没有区别
//    public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()
    val withResult = with(user) {
        this.name = "with"
        age = 21
        say("with")
    }
    println(user)
    println(withResult) // with

    // let：用it表示引用对象，并调用其方法，it不可省略
    // 返回值是语句块的最后一行，若最后一行语句无返回值，则整个let语句块也无返回值
//    public inline fun <T, R> T.let(block: (T) -> R): R = block(this)
    val letResult = user.let {
        // 无this，有it
        it.name = "let"
        it.age = 22
        it.say("let")
    }
    println(user)
    println(letResult) // let

    // apply：用this代表当前引用对象，并且调用其方法时，this可省略。
    // apply有返回值，且返回值是当前引用对象
//    public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
    val applyResult = user.apply {
        this.name = "apply"
        age = 23
        say("apply")
    }
    println(user)
    println(applyResult) // User(name=apply, age=23)
}

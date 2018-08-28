package com.hysea.basic.string

fun main(args: Array<String>) {
//    testThreeQuote()
//    testString()
//    strFind()
//    subStr()
//    replaceStr()

    commonMethod()
}

/**
 * 常用方法
 */
fun commonMethod() {
    var str = "hello kotlin"
    // 获取长度
    println("length=${str.length}")

    // 统计重复字符
    println("o的个数：${str.count { it == 'o' }}")

    // 验证字符串
    // isEmpty():其源码是判断其length是等于0，若等于0则返回true,反之返回false。不能直接用于可空的字符串
    // isNotEmpty():其源码是判断其length是否大于0，若大于0则返回true,反之返回false。不能直接用于可空的字符串
    // isNullOrEmpty():其源码是判断该字符串是否为null或者其length是否等于0
    // isBlank():其源码是判断其length是否等于0,或者判断其包含的空格数是否等于当前的length。不能直接用于可空的字符串
    // isNotBlank():其源码是对isBlank()函数取反。不能直接用于可空的字符串
    // isNullOrBlank(): 其源码判断该字符串是否为null。或者调用isBlank()函数


    // 可以看出当string为可空变量的时候，isNullOrEmpty()和isNullOrBlank可以不做直接调用而不做任何处理
//    val string : String? = "kotlin"
//    println(string?.isEmpty())
//    println(string?.isNotEmpty())
//    println(string.isNullOrEmpty())
//    println(string?.isBlank())
//    println(string?.isNotBlank())
//    println(string.isNullOrBlank())

    // 字符串连接
    println(str.plus(" kotlin is good")) // hello kotlin kotlin is good

    // 字符串反转
    println(str.reversed()) //niltok olleh

    // 判断字符串的起始于结尾
    // startsWith()  endsWith()
    str = "http://IMG_20180803.jpg"
    println(str.startsWith("http"))
    println(str.endsWith("jpg"))

}

/**
 * kotlin中三个引号 """ 中可以包含换行符等特殊字符，不需要转义
 */
fun testThreeQuote() {
    println("""
        fun main(args: Array<String>) {
            testThreeQuote()
        }""")
}

/**
 * Kotlin中，美元符号$是特殊字符，在字符串中不能直接显示，必须经过转义，方法1是用反斜杠，方法二是${'$'}
 */
fun testString() {
    println("content is \$string")
    println("content is ${'$'}string")
}

/**
 * 字符串查找
 * str.xxx与str.xxxOrNull的区别
 * str.xxx：如果没有获取到满足条件的元素，则会抛出NoSuchElementException异常
 * str.xxxOrNull:如果没有获取到满足条件的元素，则返回null
 */
fun strFind() {
    val str = "hello kotlin"
    // 获取第一个元素,等价于 str.get(0)、str[0]
    // 相应的方法还有 str.firstOrNull()
    println(str.first())
    // 获取最后一个元素
    // 相应的方法还有 str.lastOrNull()
    println(str.last())

    // 获取第一个满足条件的元素
    println(str.first { it == 'k' })
    println(str.firstOrNull { it == 'm' })

    // find{}、findLast{} 都是对firstOrNull lastOrNull函数进行处理
//    public inline fun CharSequence.find(predicate: (Char) -> Boolean): Char? {
//        return firstOrNull(predicate)
//    }

    // 查找对应元素的下标
//    indexOf() : 查找某一个元素或字符串在原字符串中第一次出现的下标。
//    indexLastOf() : 查找某一个元素或字符串在原字符串中最后一次出现的下标。
//    indexOfFirst{} : 同indexOf()
//    indexOfLast{} : 同indexLastOf()

    // 字符串遍历
    str.withIndex().forEach {
        println("index = ${it.index} , value=${it.value}")
    }
}

/**
 * 分割字符串
 */
fun subStr() {
    var str = "hello kotlin"
    // substring()方法与Java类似
    println(str.substring(str.indexOfFirst { it == 'k' }))
    // str.substring()：接受一个IntRang类型参数
    // public fun String.substring(range: IntRange): String = substring(range.start, range.endInclusive + 1)
    println(str.substring(0, 3)) // hel
    println(str.substring(IntRange(0, 3))) //hell

    // subSequence()与substring()类似
    str = "12.345-6.A"
    println(str.split(".", "-")) // [12, 345, 6, A]

    str = "/user/hysea/kotlin-book/chapter.doc"
    val directory = str.substringBeforeLast("/")
    val fullName = str.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("dir:$directory, fileName:$fileName, extension:$extension") // dir:/user/hysea/kotlin-book, fileName:chapter, extension:doc

}

fun replaceStr() {
    var str = "hello kotlin"
    println(str.replace('o', 'O')) // 替代字符
    println(str.replace("hello", "good")) // 替代字符串

    // 根据正则匹配替换
    str = "1234a kotlin 5678 3 is 4"
    println(str.replace(Regex("[0-9]+"), "kotlin")) // kotlina kotlin kotlin kotlin is kotlin

    // replaceFirst:满足条件的第一个字符或字符串替换成新的字符或字符串
    str = "hello kotlin"
    println(str.replaceFirst('l', 'L'))

    // replaceBefore 截取满足条件的第一个字符或字符串后面的字符串，包含满足条件字符或字符串自身，并在其前面加上新的字符串
    // replaceBeforeLast() 截取满足条件的最后一个字符或字符串后面的字符串，包含满足条件字符或字符串自身，并在其前面加上新的字符串。
    println(str.replaceBefore('o', "H")) // Ho kotlin
    println(str.replaceBeforeLast('o', "H")) // Hotlin

    // replaceAfter 截取满足条件的第一个字符或字符串前面的字符串，包含满足条件字符或字符串自身，并在其后面加上新的字符串。
    println(str.replaceAfter('o', "H")) // helloH

}
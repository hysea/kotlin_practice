package com.hysea.basic.collection


fun main(args: Array<String>) {
//    testImmutableList()
//    testMutableList()
//    testToMutable()
//    testTraverseList()
//    testListFunction()
    testListOperator()
}

fun testListOperator() {
    // any() 判断集合至少有一个元素
    // any(predicate: (T) -> Boolean) 判断集合中是否有满足条件的元素  判断集合中是否有满足条件的元素,如果至少有一个满足条件返回true，否则false
    // all(predicate: (T) -> Boolean) 判断集合中的元素是否都满足条件  当且仅当该集合中所有元素都满足条件时，返回true；否则都返回false。
    // none 判断集合无元素 如果该集合没有任何元素，返回true，否则返回false
    // none(predicate: (T) -> Boolean)判断集合中所有元素都不满足条件  当且仅当集合中所有元素都不满足条件时返回true，否则返回false
    // count()  计算集合中元素的个数
    // count(predicate: (T) -> Boolean) 计算集合中满足条件的元素的个数
    var list = listOf(1, 2, 3, 4, 6, 8)
    println(list.count())  // 6
    println(list.count { it % 2 == 0 })  // 4

    // reduce 从第一项到最后一项进行累计运算
    // 首先把第一个元素赋值给累加子accumulator，然后逐次向后取元素累加，
    // 新值继续赋值给累加子accumulator = operation(accumulator, iterator.next())，
    // 以此类推。最后返回累加子的值。
    println(list.reduce({ sum, next -> sum + next })) // 24
    val strList = listOf("a", "b", "c")
    println(strList.reduce({ total, str -> total + str })) // abc

    // reduceRight从最后一项到第一项进行累计运算
    println(strList.reduceRight({ total, str -> str + total }))  // cba

    // fold(initial: R, operation: (acc: R, T) -> R): R 带初始值的reduce
    // fold函数给累加子赋了初始值initial
    println(list.fold(100, { total, next -> total + next }))  // 124


    // forEachIndexed 带index(下标) 的元素遍历
    list.forEachIndexed { index, value -> println("index=$index,value=$value") }

    // max 、min查询最大、最小的元素，空集则返回null
    // maxBy(selector: (T) -> R): T? 、 minBy(selector: (T) -> R): T?获取函数映射结果的最大值、最小值对应的那个元素的值，如果没有则返回null
    // 不直接比较集合元素的大小，而是以集合元素为入参的函数selector: (T) -> R 返回值来比较大小，最后返回此元素的值

    // sumBy(selector: (T) -> Int): Int 获取函数映射值的总和

    // take(n: Int): List<T> 挑出该集合前n个元素的子集合  如果n等于0，返回空集；如果n大于集合size，返回该集合
    // takeWhile(predicate: (T) -> Boolean): List<T> 挑出满足条件的元素的子集合
    // 从第一个元素开始，判断是否满足predicate为true，如果满足条件的元素就丢到返回ArrayList中。只要遇到任何一个元素不满足条件，就结束循环，返回list

    list = listOf(1, 2, 4, 6, 8, 9)
    println(list.takeWhile { it % 2 == 0 }) // []
    println(list.takeWhile { it % 2 == 1 }) // [1]
    list = listOf(2, 4, 6, 8, 9, 10, 12)
    println(list.takeWhile { it % 2 == 0 }) // [2, 4, 6, 8]

    // takeLast 挑出后n个元素的子集合
    // takeLastWhile(predicate: (T) -> Boolean) 从最后开始挑出满足条件元素的子集合

    // drop(n: Int) 去除前n个元素返回剩下的元素的子集合
    // dropWhile(predicate: (T) -> Boolean) 去除满足条件的元素返回剩下的元素的子
    // 去除满足条件的元素，当遇到一个不满足条件的元素时，中止操作，返回剩下的元素子集合。

    // dropLast(n: Int) 从最后去除n个元素
    // dropLastWhile(predicate: (T) -> Boolean) 从最后满足条件的元素

    // slice(indices: IntRange) 取开始下标至结束下标元素子集合
    println(list.slice(2..4)) // [6, 8, 9]
    // slice(indices: Iterable<Int>) 返回指定下标的元素子集合


    // filterTo(destination: C, predicate: (T) -> Boolean) 过滤出满足条件的元素并赋值给destination
    // 把满足过滤条件的元素组成的子集合赋值给入参destination。
    val dest = mutableListOf<Int>()
    println(list.filterTo(dest, { it % 2 == 0 }))
    println(dest) // [2, 4, 6, 8, 10, 12]

    // filter(predicate: (T) -> Boolean)过滤出满足条件的元素组成的子集合
    // filterNot(predicate: (T) -> Boolean), 用来过滤所有不满足条件的元素
    // filterNotNull() 过滤掉null元素


    // map(transform: (T) -> R): List<R>  将集合中的元素通过转换函数transform映射后的结果，存到一个集合中返回。
    list = listOf(1, 2, 3, 4, 5, 6)
    println(list.map { it }) // [1, 2, 3, 4, 5, 6]
    println(list.map { it * it }) // [1, 4, 9, 16, 25, 36]

    

}

fun testListFunction() {
    // add set remove clear等于Java类似

    // elementAt(index: Int): T  查找下标对应的元素，如果下标越界会抛IndexOutOfBoundsException。
    val list = mutableListOf(1, 2, 3, 4)
    println(list.elementAt(2)) // 3
//    println(list.elementAt(4)) // java.lang.IndexOutOfBoundsException: Index: 4, Size: 4

    // 针对越界的处理：两个函数
    // elementAtOrElse(index: Int, defaultValue: (Int) -> T) 查找下标对应元素，如果越界会根据方法返回默认值
    println(list.elementAtOrElse(4, { 10 })) // 10
    // elementAtOrNull(index: Int): T? : 查找下标对应元素，如果越界就返回null
    println(list.elementAtOrNull(4)) // null

    // first()  返回集合第1个元素，如果是空集，抛出异常NoSuchElementException
    println(list.first())
//    println(listOf<Int>().first()) // java.util.NoSuchElementException: List is empty.
    // 对应的有针对异常处理的函数firstOrNull(): T?
    println(listOf<Int>().firstOrNull()) // null
    // first(predicate: (T) -> Boolean): T  返回符合条件的第一个元素，没有则抛异常NoSuchElementException 。
    println(list.first { it % 2 == 0 && it > 0 }) // 2
//    println(list.first { it > 10 }) //java.util.NoSuchElementException: Collection contains no element matching the predicate.
    // 对应的有针对异常处理的函数firstOrNull(predicate: (T) -> Boolean): T? ，返回符合条件的第一个元素，没有就返回null
    println(list.firstOrNull { it > 4 }) // null


    // indexOf(element: T): Int  返回指定下标的元素，没有则返回-1
    // indexOfFirst(predicate: (T) -> Boolean): Int  返回第一个符合条件的元素下标，没有就返回-1
    // indexOfLast(predicate: (T) -> Boolean): Int  返回最后一个符合条件的元素下标，没有就返回-1

    // last()  返回集合最后一个元素，空集则抛出异常NoSuchElementException。
    // last(predicate: (T) -> Boolean): T  返回符合条件的最后一个元素，没有就抛NoSuchElementException
    // 对应的针对越界处理的lastOrNull函数：返回符合条件的最后一个元素，没有则返回null
    // lastIndexOf(element: T): Int  返回符合条件的最后一个元素，没有就返回-1
    val strList = listOf("abc", "123", "qwe", "abc", "fff")
    println(strList.lastIndexOf("abc")) // 3

    // single(): T  该集合如果只有1个元素，则返回该元素。否则，抛异常。
    var singleList = listOf(2)
    println(singleList.single()) // 2
    singleList = listOf(1, 2)
    println(singleList.single()) //java.lang.IllegalArgumentException: List has more than one element.

    // single(predicate: (T) -> Boolean): T   返回符合条件的单个元素，如有没有符合的抛异常NoSuchElementException，或超过一个的抛异常IllegalArgumentException。
}

/**
 * 测试遍历集合
 */
fun testTraverseList() {
    val list = listOf(1, 2, 3, 9, 8, 7)

    // 1、使用Iterator迭代器
    val iterator = list.iterator()
    while (iterator.hasNext()) {
        print("${iterator.next()}${if (iterator.hasNext()) " , " else ""}")
    }

    println()
    println("-------------------------")
    // 2、使用forEach
    list.forEach {
        print(it)
    }

}

/**
 * 测试创建不可变集合
 */
fun testImmutableList() {
    // public inline fun <T> listOf(): List<T> = emptyList()
    val emptyList = listOf<String>() // 注意这里的变量类型不能省略
    println(emptyList) // []
    println(emptyList::class.java) // class kotlin.collections.EmptyList

    // public fun <T> listOf(element: T): List<T> = java.util.Collections.singletonList(element)
    val singleList = listOf<Int>(1)
    println(singleList) // [1]
    println(singleList::class.java) // class java.util.Collections$SingletonList

    // public fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
    val list = listOf<Int>(1, 2, 3, 4, 5) // 无add()等方法
    println(list) // [1, 2, 3, 4, 5]
    println(list::class.java) //class java.util.Arrays$ArrayList
}

/**
 * 测试创建可变集合
 */
fun testMutableList() {
    // 可变集合,使用mutableListOf函数创建的集合，实际上背后调用的是java.util.ArrayList类的相关方法
    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList) //[1, 2, 3]
    println(mutableList::class.java) // class java.util.ArrayList
    mutableList.add(10)
    println(mutableList)
}

/**
 * 测试不变集合和可变集合之间的互转
 */
fun testToMutable() {
    val list = listOf(1, 2, 3)
    // 将不可变集合转变成可变集合
    val toMutableList = list.toMutableList()
    toMutableList.add(100)
    println(toMutableList)

    // 将可变集合转变成不可变集合
    val toList = toMutableList.toList()
    println(toList)
}


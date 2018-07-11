package com.hysea.singleton.kotlin

/**
 * 单例模式，对应于Java中的饿汉式
 */
object Config1 {
    fun message(): String {
        return "我是单例模式，对应于Java中的饿汉式"
    }
}
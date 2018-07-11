package com.hysea.singleton.kotlin

class Config4 {
    companion object {
        val INSTANCE by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Config4()
        }
    }
}
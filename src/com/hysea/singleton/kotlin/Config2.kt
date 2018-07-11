package com.hysea.singleton.kotlin

class Config2 {
    companion object {
        val INSTANCE by lazy(LazyThreadSafetyMode.NONE) {
            Config2()
        }
    }
}
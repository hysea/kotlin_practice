package com.hysea.singleton.kotlin

class Config5 private constructor() {
    companion object {
        fun getInstance() = Holder.INSTANCE
    }

    private object Holder {
        val INSTANCE = Config5()
    }
}
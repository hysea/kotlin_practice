package com.hysea.singleton.kotlin

class Config3 {
    companion object {
        private var instance: Config3? = null

        @Synchronized
        fun get(): Config3? {
            if (null == instance) {
                instance = Config3()
            }
            return instance
        }
    }
}
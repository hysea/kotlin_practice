package com.hysea.singleton.java;

/**
 * 同步锁避免单例不会被重复创建
 */
public class Config3 {
    private static Config3 INSTANCE;

    private Config3() {
    }


    public static synchronized Config3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Config3();
        }
        return INSTANCE;
    }
}

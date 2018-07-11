package com.hysea.singleton.java;

/**
 * 饿汉式单例：直接在加载类的时候创建
 */
public class Config1 {
    private static Config1 INSTANCE = new Config1();

    private Config1() {

    }

    public static Config1 getInstance() {
        return INSTANCE;
    }
}

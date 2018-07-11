package com.hysea.singleton.java;

/**
 * 懒汉式单例，这种方式虽然避免了类加载时创建，但是线程不安全
 * 如果同时多个类获取单例，有可能会创建多个单例，因此可以在创建单例的时候加线程锁
 */
public class Config2 {

    private static Config2 INSTANCE;

    private Config2() {
    }

    public static Config2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Config2();
        }
        return INSTANCE;
    }
}

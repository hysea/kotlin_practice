package com.hysea.singleton.java;

/**
 * 双重校验
 */
public class Config4 {
    private static Config4 INSTANCE;

    private Config4() {
    }

    public static Config4 getInstance() {
        if (INSTANCE == null) {
            synchronized (Config4.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Config4();
                }
            }
        }
        return INSTANCE;
    }
}

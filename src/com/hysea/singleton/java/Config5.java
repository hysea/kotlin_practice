package com.hysea.singleton.java;

/**
 * 静态内部类：这种写法避免了类加载时初始化单例，同时将同步锁问题交给虚拟机处理
 */
public class Config5 {
    private Config5() {

    }

    public static Config5 getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static Config5 INSTANCE = new Config5();
    }
}

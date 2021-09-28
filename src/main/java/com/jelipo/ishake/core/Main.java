package com.jelipo.ishake.core;

import com.jelipo.ishake.core.proxy.ProxyManager;
import com.jelipo.ishake.core.util.TestInterface;

public class Main {


    public static void main(String[] args) {
        var classLoader = String.class.getClassLoader();
        var systemClassLoader = ClassLoader.getSystemClassLoader();
        var proxyManager = new ProxyManager();
        var test = proxyManager.getProxy(TestInterface.class);
        System.out.println(test.sayHello());
    }

}

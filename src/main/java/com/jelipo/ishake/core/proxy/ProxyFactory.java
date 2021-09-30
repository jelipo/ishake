package com.jelipo.ishake.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    protected static  <T> T newProxyObj(Class<T> clazz, InvocationHandler invocationHandler) throws IllegalArgumentException {
        if (!clazz.isInterface()) {
            throw new IllegalArgumentException(clazz.getName() + " is not an interface class");
        }
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, invocationHandler);
    }

}

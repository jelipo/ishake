package com.jelipo.ishake.core.proxy;

import java.lang.reflect.Proxy;

public class ProxyManager {

    private final InvokeHandler invokeHandler;

    public ProxyManager() {
        this.invokeHandler = new InvokeHandler();
    }

    public <T> T getProxy(Class<T> clazz) throws IllegalArgumentException {
        if (!clazz.isInterface()) {
            throw new IllegalArgumentException(clazz.getName() + " is not an interface class");
        }
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this.invokeHandler);
    }

}

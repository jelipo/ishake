package com.jelipo.ishake.core.proxy;

public class ProxyManager {

    private final ObjProxyCache objProxyCache;

    private final InvokeHandler invokeHandler;

    public ProxyManager() {
        this.objProxyCache = new ObjProxyCache();
        this.invokeHandler = new InvokeHandler(objProxyCache);
    }

    private <T> T buildNewProxyObj(String host, Class<T> clazz) {
        T proxyObj = ProxyFactory.newProxyObj(clazz, this.invokeHandler);
        objProxyCache.put(host, proxyObj);
        return proxyObj;
    }

}

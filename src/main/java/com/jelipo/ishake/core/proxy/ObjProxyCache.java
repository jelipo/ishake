package com.jelipo.ishake.core.proxy;

import java.util.concurrent.ConcurrentHashMap;

public class ObjProxyCache {

    private final ConcurrentHashMap<Integer, String> proxyCache = new ConcurrentHashMap<>(64);


    public void put(String host, Object proxyObj) {
        var hashCode = proxyObj.hashCode();
        proxyCache.put(hashCode, host);
    }

    public String getHost(Object proxyObj) {
        return proxyCache.get(proxyObj.hashCode());
    }

}

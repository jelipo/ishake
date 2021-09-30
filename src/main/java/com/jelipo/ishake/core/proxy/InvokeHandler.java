package com.jelipo.ishake.core.proxy;

import com.jelipo.ishake.core.util.MethodUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Optional;

public class InvokeHandler implements InvocationHandler {

    private final ObjProxyCache hostCache;

    private final HashMap<Integer, ProxyMethodInfo> methodInfoCache = new HashMap<>();

    public InvokeHandler(ObjProxyCache objProxyCache) {
        this.hostCache = objProxyCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        var host = hostCache.getHost(proxy);
        if (host == null) {
            throw new RuntimeException("Unknown proxy object: " + proxy);
        }
        var methodHashCode = MethodUtil.methodHashCode(method);
        var methodInfo = this.methodInfoCache.get(methodHashCode);
        if (methodInfo == null) {
            var optionalInfo = this.checkAndAnalyzeMethod(method, args);
            if (optionalInfo.isEmpty()) {
                if (canRunDefaultMethod(method)) {
                    return tryToRunDefaultMethod(method, args);
                } else {
                    throw new UnsupportedOperationException(method.getName() + " not configured correctly");
                }
            }
            methodInfo = optionalInfo.get();
            this.methodInfoCache.put(methodHashCode, methodInfo);
        }
        // 发送Http请求
        return request(host, methodInfo);
    }

    /**
     * 检查是否是合规的Method和参数，如果是则返回包装好的 {@link ProxyMethodInfo}
     * 反之则返回null
     */
    private Optional<ProxyMethodInfo> checkAndAnalyzeMethod(Method method, Object[] args) {
        // TODO 检查是否合规并生成
        return Optional.empty();
    }

    private Object tryToRunDefaultMethod(Method method, Object[] args) throws Throwable {
        // TODO 尝试执行default
        return Optional.empty();
    }

    private boolean canRunDefaultMethod(Method method) {
        // TODO check is default method
        return false;
    }

    private Object request(String host, ProxyMethodInfo proxyMethodInfo) {
        // TODO 发送HTTP请求
        return null;
    }
}

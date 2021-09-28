package com.jelipo.ishake.core.proxy;

import com.jelipo.ishake.core.util.MethodUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class InvokeHandler implements InvocationHandler {

    private final HashMap<Integer, ProxyMethodInfo> methodInfoCache = new HashMap<>();


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        var methodHashCode = MethodUtil.methodHashCode(method);
        var methodInfo = this.methodInfoCache.get(methodHashCode);
        if (methodInfo == null) {
            // TODO 检查method是否合规
            //  如果不合规，则先判断是否是default方法，是default就是尝试执行default的内容，非default方法则会抛出异常

        }
        System.out.println("调用了：" + method.getName());
        return null;
    }

    /**
     * 检查是否是合规的Method和参数，如果是则返回包装好的 {@link ProxyMethodInfo}
     * 反之则返回null
     */
    private ProxyMethodInfo checkAndAnalyzeMethod(Method method, Object[] args) {
        return null;
    }

}

package com.jelipo.ishake.core.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用Cglib实现的Method拦截器
 */
public class CglibInterceptor implements MethodInterceptor {

    private Object object = new Object();


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(method.invoke(obj, args));
        return null;
    }
}

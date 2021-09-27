package com.jelipo.ishake.core;

import com.jelipo.ishake.core.proxy.CglibInterceptor;
import com.jelipo.ishake.core.proxy.ProxyFilter;
import com.jelipo.ishake.core.util.MethodUtil;
import net.sf.cglib.proxy.Enhancer;


public class Main {


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 设置父类--可以是类或者接口
        enhancer.setSuperclass(MethodUtil.class);
        enhancer.setCallback(new CglibInterceptor());
        enhancer.setCallbackFilter(new ProxyFilter());
        MethodUtil methodUtil = (MethodUtil) enhancer.create();
        System.out.println(methodUtil.test());
    }


}

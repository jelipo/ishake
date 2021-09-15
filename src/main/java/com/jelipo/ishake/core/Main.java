package com.jelipo.ishake.core;

import com.jelipo.ishake.core.pojo.Data;

import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) {
        for (Method method : Data.class.getMethods()) {
            System.out.println(method.getName() + ":" + method.hashCode());
            var methodHashCode = switch (method.getParameterCount()) {
                case 0 -> method.hashCode();
                default -> 
            }
        }
    }
}

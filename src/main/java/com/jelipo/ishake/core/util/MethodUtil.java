package com.jelipo.ishake.core.util;

import java.lang.reflect.Method;

public class MethodUtil {

    public static int methodHashCode(Method method) {
        var methodNameHashCode = method.hashCode();
        return switch (method.getParameterCount()) {
            case 0 -> methodNameHashCode;
            case 1 -> methodNameHashCode ^ method.getParameterTypes()[0].getName().hashCode();
            case 2 -> methodNameHashCode ^ method.getParameterTypes()[0].getName().hashCode() ^
                    method.getParameterTypes()[1].getName().hashCode();
            case 3 -> methodNameHashCode ^ method.getParameterTypes()[0].getName().hashCode() ^
                    method.getParameterTypes()[1].getName().hashCode() ^
                    method.getParameterTypes()[2].getName().hashCode();
            default -> parametersHashCode(method.getParameterTypes());
        };
    }

    private static int parametersHashCode(Class<?>[] classes) {
        var hashCode = classes[0].getName().hashCode();
        for (int i = 1; i < classes.length; i++) {
            hashCode = hashCode ^ classes[i].getName().hashCode();
        }
        return hashCode;
    }

    public String test() {
        return "Hello world";
    }
}

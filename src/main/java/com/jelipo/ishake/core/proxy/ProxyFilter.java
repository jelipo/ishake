package com.jelipo.ishake.core.proxy;

import com.jelipo.ishake.core.annotation.HttpGet;
import com.jelipo.ishake.core.annotation.HttpPost;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author jelipo
 */
public class ProxyFilter {

    /**
     * Http方法注解的Class的Hashcode的Set集合
     */
    private static final Set<Integer> HTTP_CLASS_HASH_SET = Set.of(
            HttpGet.class.getName().hashCode(),
            HttpPost.class.getName().hashCode()
    );


    public boolean accept(Method method) {


        // 检查注解
        var annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            var annHashCode = annotation.annotationType().getName().hashCode();
            if (HTTP_CLASS_HASH_SET.contains(annHashCode)) {
                return true;
            }
        }
        return false;
    }
}

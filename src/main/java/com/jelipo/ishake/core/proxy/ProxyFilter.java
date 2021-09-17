package com.jelipo.ishake.core.proxy;

import com.jelipo.ishake.core.annotation.HttpGet;
import com.jelipo.ishake.core.annotation.HttpPost;
import net.sf.cglib.proxy.CallbackFilter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public class ProxyFilter implements CallbackFilter {

    /**
     * Http方法注解的Class的Hashcode的Set集合
     */
    private static final Set<Integer> httpClassHashSet = Set.of(
            HttpGet.class.getName().hashCode(),
            HttpPost.class.getName().hashCode()
    );

    @Override
    public int accept(Method method) {
        var integers = Set.of(
                HttpGet.class.getName().hashCode(),
                HttpPost.class.getName().hashCode()
        );
        // 检查注解
        var annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            var annHashCode = annotation.annotationType().getName().hashCode();
            if (httpClassHashSet.contains(annHashCode)) {
                return 1;
            }
        }
        return 0;
    }
}

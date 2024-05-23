package cn.pc.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/21 下午2:01
 */
public interface MethodMatcher {
    /**
     * 方法匹配，找到表达式范围内匹配下的目标类和方法
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method , Class<?> targetClass);
}

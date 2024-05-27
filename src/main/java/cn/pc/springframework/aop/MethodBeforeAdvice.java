package cn.pc.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/27 上午10:38
 */
public interface MethodBeforeAdvice extends BeforeAdvice{


    void before(Method method, Object[] args, Object target) throws Throwable;
}

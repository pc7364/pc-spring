package cn.pc.springframework.test.bean;

import cn.pc.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/27 下午3:03
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }


}

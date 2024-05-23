package cn.pc.springframework.test.bean;



import cn.pc.springframework.aop.AdvisedSupport;
import cn.pc.springframework.aop.TargetSource;
import cn.pc.springframework.aop.aspectj.AspectJExpressionPointcut;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/23 上午11:50
 */
public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            System.out.println("监控 - Begin By AOP");
            System.out.println("方法名称：" + invocation.getMethod());
            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
            System.out.println("监控 - End\r\n");
        }
    }

}

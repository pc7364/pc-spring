package cn.pc.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.DisposableBean;
import cn.pc.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/14 下午3:26
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    /**
     * 目前有实现接口 DisposableBean、配置信息 destroy-method，两种方式。
     * 而这两种方式的销毁动作是由 AbstractApplicationContext 在注册虚拟机钩子后看，虚拟机关闭前执行的操作动作。
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        // 实现接口 DisposableBean
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }

        // 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if(StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method) {
                throw new BeansException("destroy method not found: " + destroyMethodName);
            }
            method.invoke(bean);
        }
    }
}

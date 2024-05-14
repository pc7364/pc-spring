package cn.pc.springframework.beans.factory.config;

import cn.pc.springframework.beans.BeansException;

/**
 * @Desc 提供了修改新实例化 Bean 对象的扩展点。
 * @Author pc
 * @Date 2024/5/13 上午10:38
 */
public interface BeanPostProcessor {

    /**
     * 在bean对象执行初始化之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean , String beanName) throws BeansException;

    /**
     * 在bean对象执行初始化之后 执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException;

}

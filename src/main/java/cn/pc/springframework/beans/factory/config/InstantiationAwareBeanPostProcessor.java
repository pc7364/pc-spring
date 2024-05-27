package cn.pc.springframework.beans.factory.config;

import cn.pc.springframework.beans.BeansException;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/27 上午11:32
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}

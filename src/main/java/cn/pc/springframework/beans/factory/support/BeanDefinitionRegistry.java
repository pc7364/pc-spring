package cn.pc.springframework.beans.factory.support;

import cn.pc.springframework.beans.factory.config.BeanDefinition;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:47
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

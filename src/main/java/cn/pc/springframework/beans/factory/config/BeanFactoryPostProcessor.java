package cn.pc.springframework.beans.factory.config;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/13 上午10:37
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的BeanDefinition加载完成后，实例化Bean对象之前，提供修改BeanDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}

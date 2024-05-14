package cn.pc.springframework.beans.factory;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.pc.springframework.beans.factory.config.BeanDefinition;
import cn.pc.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午4:56
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory , AutowireCapableBeanFactory , ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}

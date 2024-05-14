package cn.pc.springframework.test.common;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.PropertyValue;
import cn.pc.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.pc.springframework.beans.factory.config.BeanDefinition;
import cn.pc.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/14 下午2:04
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("company","改成  百度"));
    }
}

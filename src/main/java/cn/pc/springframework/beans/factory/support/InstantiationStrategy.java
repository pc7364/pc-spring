package cn.pc.springframework.beans.factory.support;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 上午11:29
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition , String beanName , Constructor ctor , Object[] args ) throws BeansException;

}

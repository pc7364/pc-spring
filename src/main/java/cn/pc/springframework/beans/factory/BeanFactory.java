package cn.pc.springframework.beans.factory;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:12
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

}

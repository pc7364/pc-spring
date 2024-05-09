package cn.pc.springframework.beans.factory.support;

import cn.pc.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:48
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<Object, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 这个方法可以被继承此类的其他类调用,包括：AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用。
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName , Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}

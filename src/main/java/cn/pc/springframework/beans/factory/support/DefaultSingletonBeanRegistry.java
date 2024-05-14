package cn.pc.springframework.beans.factory.support;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.DisposableBean;
import cn.pc.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:48
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<Object, Object> singletonObjects = new ConcurrentHashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void destroySingleton() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean){
        disposableBeans.put(beanName , disposableBean);
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

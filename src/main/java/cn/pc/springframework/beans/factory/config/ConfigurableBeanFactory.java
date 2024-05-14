package cn.pc.springframework.beans.factory.config;

import cn.pc.springframework.beans.factory.BeanFactory;
import cn.pc.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午5:01
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory , SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}

package cn.pc.springframework.beans.factory;

import cn.pc.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午4:57
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}

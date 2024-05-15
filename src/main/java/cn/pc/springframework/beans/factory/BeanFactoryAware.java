package cn.pc.springframework.beans.factory;

import cn.pc.springframework.beans.BeansException;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/15 上午10:05
 */
public interface BeanFactoryAware extends Aware{

    /**
     * 实现此接口，既能感知到所属的 BeanFactory
     * @param beanFactory
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}

package cn.pc.springframework.context.support;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.config.BeanPostProcessor;
import cn.pc.springframework.context.ApplicationContext;
import cn.pc.springframework.context.ApplicationContextAware;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/15 上午10:06
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

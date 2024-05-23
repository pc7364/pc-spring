package cn.pc.springframework.test.common;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.pc.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.pc.springframework.beans.factory.config.BeanPostProcessor;
import cn.pc.springframework.test.bean.UserService;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/14 下午2:05
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + beanName);
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
//            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + beanName);
        return bean;
    }
}

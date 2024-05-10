package cn.pc.springframework;

import cn.pc.springframework.bean.UserDao;
import cn.pc.springframework.bean.UserService;
import cn.pc.springframework.beans.factory.BeanFactory;
import cn.pc.springframework.beans.factory.PropertyValue;
import cn.pc.springframework.beans.factory.PropertyValues;
import cn.pc.springframework.beans.factory.config.BeanDefinition;
import cn.pc.springframework.beans.factory.config.BeanReference;
import cn.pc.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:14
 */
public class ApiTest {

    // 01-测试
//    @Test
//    public void test_BeanFactory(){
//        // 1.初始化 BeanFactory
//        BeanFactory beanFactory = new BeanFactory();
//
//        // 2.注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//    }

    /**
     * test-02
     */
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        System.out.println(userService == userService2);
    }


    /**
     * test-03
     */
    @Test
    public void test_BeanFactory03(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);


        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService" , "pc");
        userService.queryUserInfo();

        System.out.println(userService == userService2);
        System.out.println();
    }


    /**
     * test-04
     */
    @Test
    public void test_BeanFactory04(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3 userService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId" , "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao" , new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class , propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();

        System.out.println(userService2);
    }

}

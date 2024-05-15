package cn.pc.springframework.test.bean;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.*;
import cn.pc.springframework.context.ApplicationContext;
import cn.pc.springframework.context.ApplicationContextAware;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:14
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware , ApplicationContextAware , BeanFactoryAware {

    private String uId;

    private UserDao userDao;

    private String company;

    private String location;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", userDao=" + userDao +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}

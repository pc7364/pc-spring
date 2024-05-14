package cn.pc.springframework.test.bean;

import cn.pc.springframework.beans.factory.DisposableBean;
import cn.pc.springframework.beans.factory.InitializingBean;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:14
 */
public class UserService implements InitializingBean , DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("执行 userService destroy 方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行 userService afterPropertiesSet 方法");
    }
}

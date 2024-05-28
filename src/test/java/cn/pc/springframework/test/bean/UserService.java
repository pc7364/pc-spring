package cn.pc.springframework.test.bean;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.*;
import cn.pc.springframework.context.ApplicationContext;
import cn.pc.springframework.context.ApplicationContextAware;
import cn.pc.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:14
 */
@Component("userService")
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}




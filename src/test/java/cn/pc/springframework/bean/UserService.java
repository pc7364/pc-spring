package cn.pc.springframework.bean;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:14
 */
public class UserService {

    private String name;

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {

    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}

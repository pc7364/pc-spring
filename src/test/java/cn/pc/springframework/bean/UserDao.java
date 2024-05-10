package cn.pc.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "pc");
        hashMap.put("10002", "张三");
        hashMap.put("10003", "李四");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}

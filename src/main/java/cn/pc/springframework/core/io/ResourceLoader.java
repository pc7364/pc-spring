package cn.pc.springframework.core.io;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午4:52
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 定义获取资源接口，里面传递 location 地址即可。
     * @param location
     * @return
     */
    Resource getResource(String location);

}

package cn.pc.springframework.beans.factory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/14 下午3:27
 */
public interface InitializingBean {
    /**
     * bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}

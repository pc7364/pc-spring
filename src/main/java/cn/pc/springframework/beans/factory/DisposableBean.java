package cn.pc.springframework.beans.factory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/14 下午3:27
 */
public interface DisposableBean {

    void destroy() throws Exception;
}

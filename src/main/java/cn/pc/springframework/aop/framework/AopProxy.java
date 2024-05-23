package cn.pc.springframework.aop.framework;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/21 下午2:03
 */
public interface AopProxy {
    /**
     * 用于获取代理类
     * @return
     */
    Object getProxy();
}

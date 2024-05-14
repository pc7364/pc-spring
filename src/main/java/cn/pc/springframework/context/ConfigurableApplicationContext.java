package cn.pc.springframework.context;

import cn.pc.springframework.beans.BeansException;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/13 上午10:40
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutDownHook();

    void close();

}

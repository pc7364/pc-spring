package cn.pc.springframework.context.event;

import cn.pc.springframework.context.ApplicationEvent;
import cn.pc.springframework.context.ApplicationListener;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/17 下午3:15
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加一个监听器来接收所有事件的通知。
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * remove
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的应用程序事件多播到适当的监听器。
     * @param event
     */
    void multicastEvent(ApplicationEvent event);


}

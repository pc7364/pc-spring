package cn.pc.springframework.context;

import java.util.EventListener;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/17 下午3:17
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理应用程序事件。
     * @param event
     */
    void onApplicationEvent(E event);

}

package cn.pc.springframework.context;

/**
 * @Desc 是整个一个事件的发布接口，所有的事件都需要从这个接口发布出去。
 * @Author pc
 * @Date 2024/5/17 下午3:17
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}

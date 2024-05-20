package cn.pc.springframework.context.event;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/17 下午3:15
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}

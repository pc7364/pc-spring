package cn.pc.springframework.context;

import java.util.EventObject;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/17 下午3:16
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}

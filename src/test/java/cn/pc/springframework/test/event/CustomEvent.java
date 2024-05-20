package cn.pc.springframework.test.event;

import cn.pc.springframework.context.event.ApplicationContextEvent;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/20 下午3:05
 */
public class CustomEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source ,Long id , String message) {
        super(source);
        this.id=id;
        this.message=message;
    }

    private Long id;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

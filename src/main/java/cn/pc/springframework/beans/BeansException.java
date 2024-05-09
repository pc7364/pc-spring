package cn.pc.springframework.beans;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:50
 * 定义bean异常
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }
    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

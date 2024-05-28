package cn.pc.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/28 上午11:45
 */
@Target({ElementType.TYPE , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}

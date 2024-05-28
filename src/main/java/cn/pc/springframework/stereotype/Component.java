package cn.pc.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/28 上午11:46
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}

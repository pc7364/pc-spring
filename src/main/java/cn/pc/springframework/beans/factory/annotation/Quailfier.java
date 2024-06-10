package cn.pc.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Desc
 * @Author pc
 * @Date 2024/6/9 15:31
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Quailfier {

    String value() default "";
}

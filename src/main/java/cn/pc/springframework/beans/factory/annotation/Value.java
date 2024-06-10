package cn.pc.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Desc
 * @Author pc
 * @Date 2024/6/9 15:31
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}

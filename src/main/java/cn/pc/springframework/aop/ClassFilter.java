package cn.pc.springframework.aop;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/21 下午2:00
 */
public interface ClassFilter {
    /**
     * 定义类匹配类，用于切点找到给定的接口和目标类。
     * @param clazz
     * @return
     */
    boolean matches(Class<?> clazz);
}

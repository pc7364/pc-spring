package cn.pc.springframework.aop;

/**
 * @Desc 切入点接口，定义用于获取 ClassFilter、MethodMatcher 的两个类
 * @Author pc
 * @Date 2024/5/21 下午2:01
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}

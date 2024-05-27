package cn.pc.springframework.aop;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/27 上午10:39
 */
public interface PointcutAdvisor extends Advisor{


    Pointcut getPointcut();
}

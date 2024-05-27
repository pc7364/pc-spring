package cn.pc.springframework.aop.aspectj;

import cn.pc.springframework.aop.Pointcut;
import cn.pc.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/27 上午10:31
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    //切面
    private AspectJExpressionPointcut pointcut;
    // 具体拦截的方法
    private Advice advice;
    // 表达式
    private String expression;



    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }


    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}

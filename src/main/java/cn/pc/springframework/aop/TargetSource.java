package cn.pc.springframework.aop;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/21 下午2:01
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget(){
        return this.target;
    }
}

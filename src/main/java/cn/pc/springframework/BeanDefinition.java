package cn.pc.springframework;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:12
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}

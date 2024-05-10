package cn.pc.springframework.beans.factory.config;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午3:33
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

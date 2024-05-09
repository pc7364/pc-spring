package cn.pc.springframework.beans.factory.config;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:12
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

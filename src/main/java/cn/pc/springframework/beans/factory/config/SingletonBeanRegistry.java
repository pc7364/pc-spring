package cn.pc.springframework.beans.factory.config;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:45
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 销毁单例bean
     */
    void registerSingleton(String beanName, Object singletonObject);
}

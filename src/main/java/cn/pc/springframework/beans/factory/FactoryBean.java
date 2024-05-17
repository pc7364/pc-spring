package cn.pc.springframework.beans.factory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/15 下午2:41
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}

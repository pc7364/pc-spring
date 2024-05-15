package cn.pc.springframework.beans.factory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/15 上午10:04
 */
public interface BeanClassLoaderAware extends Aware{

    /**
     * 实现此接口，既能感知到所属的 ClassLoader
     * @param classLoader
     */
    void setBeanClassLoader(ClassLoader classLoader);

}

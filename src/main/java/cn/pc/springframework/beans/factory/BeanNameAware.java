package cn.pc.springframework.beans.factory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/15 上午10:05
 */
public interface BeanNameAware extends Aware{

    /**
     * 实现此接口，既能感知到所属的 BeanName
     * @param name
     */
    void setBeanName(String name);

}

package cn.pc.springframework.context;

import cn.pc.springframework.beans.BeansException;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/15 上午10:07
 */
public interface ApplicationContextAware {

    /**
     * 实现此接口，既能感知到所属的Application
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}

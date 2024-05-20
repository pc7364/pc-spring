package cn.pc.springframework.context.event;

import cn.pc.springframework.beans.factory.BeanFactory;
import cn.pc.springframework.context.ApplicationEvent;
import cn.pc.springframework.context.ApplicationListener;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/17 下午3:16
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }
}

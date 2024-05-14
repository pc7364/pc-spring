package cn.pc.springframework.context.support;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.pc.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/13 上午10:41
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}

package cn.pc.springframework.context.support;

import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.pc.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.pc.springframework.beans.factory.config.BeanPostProcessor;
import cn.pc.springframework.context.ConfigurableApplicationContext;
import cn.pc.springframework.core.io.DefaultResourceLoader;

import java.util.Collections;
import java.util.Map;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/13 上午10:41
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1.创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();
        // 2.获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 添加ApplicationContextAwareProcessor 让继承自 ApplicationContextAware 的Bean对象能感知所属的 Application
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 3.在bean 实例化之前，执行beanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        // 4.BeanPostProcessor 需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 5.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public void registerShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    /**
     * 这里主要体现了关于注册钩子和关闭的方法实现，
     * 上文提到过的 Runtime.getRuntime().addShutdownHook，可以尝试验证。
     * 在一些中间件和监控系统的设计中也可以用得到，比如监测服务器宕机，执行备机启动操作。
     */
    @Override
    public void close() {
        getBeanFactory().destroySingleton();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beansOfType.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name , requiredType);
    }
}

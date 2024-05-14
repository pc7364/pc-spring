package cn.pc.springframework.context.support;

import cn.pc.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.pc.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Arrays;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/13 上午10:42
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory , this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations && configLocations.length > 0) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}

package cn.pc.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.factory.PropertyValue;
import cn.pc.springframework.beans.factory.PropertyValues;
import cn.pc.springframework.beans.factory.config.BeanDefinition;
import cn.pc.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:46
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition ,Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition , beanName , args);
            // 给bean 填充属性
            applyPropertyValues(beanName , bean , beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Unable to instantiate bean " + beanName, e);
        }
        addSingleton(beanName , bean);
        return bean;
    }

    /**
     * 接下来抽取 createBeanInstance 方法，在这个方法中需要注意 Constructor 代表了你有多少个构造函数，通过 beanClass.getDeclaredConstructors() 方式可以获取到你所有的构造函数，是一个集合。
     * 接下来就需要循环比对出构造函数集合与入参信息 args 的匹配情况，这里我们对比的方式比较简单，只是一个数量对比，而实际 Spring 源码中还需要比对入参类型，否则相同数量不同入参类型的情况，就会抛异常了。
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition , String beanName , Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition , beanName , constructorToUse , args);
    }

    /**
     * 在 applyPropertyValues 中，通过获取 beanDefinition.getPropertyValues() 循环进行属性填充操作，如果遇到的是 BeanReference，那么就需要递归获取 Bean 实例，调用 getBean 方法。
     * 当把依赖的 Bean 对象创建完成后，会递归回现在属性填充中。这里需要注意我们并没有去处理循环依赖的问题，这部分内容较大，后续补充。
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean , BeanDefinition beanDefinition ) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference){
                    // a 依赖 b 获取b的实例
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean , name , value);
            }
        }catch (Exception e){
            throw new BeansException("error setting property values" + beanName, e);
        }

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}

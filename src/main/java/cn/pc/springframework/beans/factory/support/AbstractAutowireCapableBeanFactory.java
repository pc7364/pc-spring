package cn.pc.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.PropertyValue;
import cn.pc.springframework.beans.PropertyValues;
import cn.pc.springframework.beans.factory.*;
import cn.pc.springframework.beans.factory.config.BeanDefinition;
import cn.pc.springframework.beans.factory.config.BeanPostProcessor;
import cn.pc.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName , bean , beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Unable to instantiate bean " + beanName, e);
        }
        // 注册实现了 DisposableBean 接口的对象
        registerDisposableBeanIfNecessary(beanName , bean , beanDefinition);
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


    /**
     * 主要分为两块来执行实现了 InitializingBean 接口的操作，处理 afterPropertiesSet 方法。另外一个是判断配置信息 init-method 是否存在，执行反射调用 initMethod.invoke(bean)。这两种方式都可以在 Bean 对象初始化过程中进行处理加载 Bean 对象中的初始化操作，让使用者可以额外新增加自己想要的动作。
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @return
     */
    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        if (bean instanceof Aware){
            if (bean instanceof BeanFactoryAware){
                ((BeanFactoryAware)bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware){
                ((BeanClassLoaderAware)bean).setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware){
                ((BeanNameAware)bean).setBeanName(beanName);
            }

        }

        // 1.执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean , beanName);
        //待完成内容
        try {
            invokeInitMethods(beanName , wrappedBean , beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Unable to initialize bean " + beanName, e);
        }
        // BeanPostProcessor Before 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean , beanName);
        return wrappedBean;
    }

    private Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (null == current){
                return result;
            }
            result = current;
        }
        return result;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 实现接口判断
        if (bean instanceof InitializingBean){
            ((InitializingBean)bean).afterPropertiesSet();
        }
        // 配置信息 init-method {判断是为了避免二次执行销毁}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)){
            Method method = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (method == null){
                throw new BeansException("init method '" + initMethodName + "' not found");
            }
            method.invoke(bean);
        }
    }

    private Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (null == current){
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 在创建 Bean 对象的实例的时候，需要把销毁方法保存起来，方便后续执行销毁动作进行调用。
     * 那么这个销毁方法的具体方法信息，会被注册到 DefaultSingletonBeanRegistry 中新增加的 Map<String, DisposableBean> disposableBeans 属性中去，因为这个接口的方法最终可以被类 AbstractApplicationContext 的 close 方法通过 getBeanFactory().destroySingletons() 调用。
     * 在注册销毁方法的时候，会根据是接口类型和配置类型统一交给 DisposableBeanAdapter 销毁适配器类来做统一处理。实现了某个接口的类可以被 instanceof 判断或者强转后调用接口方法
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())){
            registerDisposableBean(beanName , new DisposableBeanAdapter(bean , beanName , beanDefinition));
        }

    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}

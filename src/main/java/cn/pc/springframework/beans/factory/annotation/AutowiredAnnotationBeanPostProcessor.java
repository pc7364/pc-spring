package cn.pc.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import cn.pc.springframework.beans.BeansException;
import cn.pc.springframework.beans.PropertyValues;
import cn.pc.springframework.beans.factory.BeanFactory;
import cn.pc.springframework.beans.factory.BeanFactoryAware;
import cn.pc.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.pc.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.pc.springframework.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * @Desc
 * @Author pc
 * @Date 2024/6/9 15:30
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor , BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        //1.处理@Value注解
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Value annotation = declaredField.getAnnotation(Value.class);
            if (annotation != null) {
                String value = annotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean , declaredField.getName() , value);
            }
        }
        //2.处理注解Autowired
        for (Field declaredField : declaredFields) {
            Autowired annotation = declaredField.getAnnotation(Autowired.class);
            if (annotation != null) {
                Class<?> fieldType = declaredField.getType();
                String dependentBeanName = null;
                Quailfier quailfierAnntotation = declaredField.getAnnotation(Quailfier.class);
                Object dependentBean = null;
                if (null != quailfierAnntotation){
                    dependentBeanName = quailfierAnntotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                }else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean , declaredField.getName() , dependentBean);
            }
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}

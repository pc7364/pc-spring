package cn.pc.springframework.beans.factory.config;

import cn.pc.springframework.beans.factory.PropertyValue;
import cn.pc.springframework.beans.factory.PropertyValues;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:12
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    /**
     * 为了把属性一定交给 Bean 定义，所以这里填充了 PropertyValues 属性，同时把两个构造函数做了一些简单的优化，避免后面 for 循环时还得判断属性填充是否为空。
     * @param beanClass
     * @param propertyValues
     */
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}

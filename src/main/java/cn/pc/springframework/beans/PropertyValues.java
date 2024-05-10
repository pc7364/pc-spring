package cn.pc.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午3:34
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    // todo
    public PropertyValue[] getPropertyValues(){
        return propertyValues.toArray(new PropertyValue[propertyValues.size()]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(propertyValue)){
                return propertyValue;
            }
        }
        return null;
    }

}

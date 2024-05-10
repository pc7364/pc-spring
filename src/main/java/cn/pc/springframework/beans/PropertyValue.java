package cn.pc.springframework.beans;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午3:34
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }



    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

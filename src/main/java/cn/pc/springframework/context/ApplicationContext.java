package cn.pc.springframework.context;

import cn.pc.springframework.beans.factory.HierarchicalBeanFactory;
import cn.pc.springframework.beans.factory.ListableBeanFactory;
import cn.pc.springframework.core.io.ResourceLoader;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/13 上午10:40
 */
public interface ApplicationContext extends ListableBeanFactory , HierarchicalBeanFactory , ResourceLoader , ApplicationEventPublisher {

}

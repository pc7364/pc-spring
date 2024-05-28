package cn.pc.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.pc.springframework.beans.factory.config.BeanDefinition;
import cn.pc.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/28 上午11:44
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}

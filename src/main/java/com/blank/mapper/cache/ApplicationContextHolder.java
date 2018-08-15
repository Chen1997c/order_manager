package com.blank.mapper.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     功能描述:从spring容器中获取bean的工具类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /**
     * 根据类名得到bean
     *
     * @param className
     * @return
     */
    public static Object  getClass(String className) {
        return applicationContext.getBean(className);
    }

    /**
     * 根据类类型得到bean
     *
     * @param clazz
     * @return
     */
    public static Object getClass(Class<?> clazz){
        return applicationContext.getBean(clazz);
    }
}

package org.young.chap5.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
@Component
public class ApplicationUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (ApplicationUtils.applicationContext == null) {
            ApplicationUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationUtils.applicationContext;
    }

    public static Object getBean(String name) {
        return ApplicationUtils.applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clz) {
        return ApplicationUtils.applicationContext.getBean(clz);
    }

    public static <T> T getBean(String name, Class<T> clz) {
        return ApplicationUtils.applicationContext.getBean(name, clz);
    }
}

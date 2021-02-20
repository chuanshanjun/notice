package org.young.chap5.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * <h1>保存应用上下文</h1>
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
@Slf4j
public class ApplicationContextStore {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        log.info("Coming into ApplicationContextStore");
        ApplicationContextStore.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextStore.applicationContext;
    }
}

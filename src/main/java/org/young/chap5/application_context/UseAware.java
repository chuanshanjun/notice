package org.young.chap5.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
@Slf4j
//@Component
public class UseAware implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(applicationContext);
        assert ApplicationContextStore.getApplicationContext() != null;
        log.info("UseAware done");
    }
}

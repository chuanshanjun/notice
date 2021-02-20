package org.young.chap5.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <h1>第一种获取方式</h1>
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
@Slf4j
public class UseInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(applicationContext);
        assert ApplicationContextStore.getApplicationContext() != null;
        log.info("UseInitializer done");
    }
}

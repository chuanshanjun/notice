package org.young.chap5.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * <h2>第二种方式，使用listener</h2>
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
@Slf4j
//@Component
public class UseListener implements ApplicationListener<ApplicationContextEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(event.getApplicationContext());
        assert ApplicationContextStore.getApplicationContext() != null;
        log.info("UseListener done");
    }
}

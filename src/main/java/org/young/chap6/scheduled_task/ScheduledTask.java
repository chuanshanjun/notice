package org.young.chap6.scheduled_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author:ChuanShanJun
 * @date:2021/3/13
 * @description:
 */
@Slf4j
@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 1000)
    public void task01() throws Exception {
        while (true) {
            Thread.sleep(2000);
            log.info("Schedule Task process something");
        }
    }

    @Scheduled(fixedRate = 1000)
    public void task02() {
        log.info("Schedule Task process task02");
    }
}

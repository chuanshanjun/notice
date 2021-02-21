package org.young.chap5.default_singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.young.chap5.util.ApplicationUtils;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CoolYoungServiceTest {

    @Test
    public void test1() {
        CoolYoungService bean1 = ApplicationUtils.getBean(CoolYoungService.class);
        CoolYoungService bean2 = ApplicationUtils.getBean(CoolYoungService.class);

        bean1.add("java");
        bean1.add("rust");

        log.info("cool young bean1 {}", bean1.get());

        bean2.add("lua");

        log.info("cool young bean1 {}", bean1.get());
    }
}
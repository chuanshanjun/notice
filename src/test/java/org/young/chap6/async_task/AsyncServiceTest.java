package org.young.chap6.async_task;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

    @Autowired private AsyncService asyncService;

    @Test
    public void testProcess01() throws Exception {
        asyncService.asyncProcess01();
    }

    @Test
    public void testProcess02() throws Exception {
        Future<String> future = asyncService.asyncProcess02();
        log.info("Async Process02 Return: {}", future.get(1, TimeUnit.SECONDS));
    }

    @Test
    public void testProcess03() throws Exception {
        asyncService.asyncProcess03();
        Thread.sleep(3000);
    }
}
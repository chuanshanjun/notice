package org.young.chap6.async_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author:ChuanShanJun
 * @date:2021/3/13
 * @description:
 */
@Slf4j
@Service
public class AsyncService {

    @Async
    public void asyncProcess01() throws Exception {
        log.info("ThreadName:{}, AsyncService process01 start", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("ThreadName: {}, AsyncService process02 done", Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncProcess02() throws Exception {
        log.info("ThreadName: {}, AsyncService process02 start", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("ThreadName: {} AsyncService process02 done", Thread.currentThread().getName());
        return new AsyncResult<>("young");
    }

    @Async
    public void asyncProcess03() throws Exception {
        log.info("ThreadName: {}, AsyncService process03 start", Thread.currentThread().getName());
        Thread.sleep(2000);
        throw new RuntimeException("throw exception in asyncProcess03()");
    }
}

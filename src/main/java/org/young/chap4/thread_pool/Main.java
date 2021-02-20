package org.young.chap4.thread_pool;

import java.util.concurrent.ExecutorService;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = ExecutorsUtil.newFixedThreadPool(3, "young");

        for (int i = 0; i !=5; i++) {
            executorService.execute(new Reading("Java 实战", 5));
            executorService.execute(new Reading("Spring 实战", 5));
            executorService.execute(new Reading("SpringBoot 实战", 5));
            executorService.execute(new Reading("SpringCloud 实战", 5));
            executorService.execute(new Reading("Netty 实战", 5));
        }

        executorService.shutdown();
    }
}

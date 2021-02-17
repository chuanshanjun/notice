package org.young.chap4.atomic_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class AtomicPlus {

    private static int count = 0;
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    private static void plus(int value) throws Exception {
        // countDownLatch初始值为2
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < value; i++) {
                    count++;
                }
                // 满足一个条件后countDownLatch 减1
                countDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < value; i++) {
                    count++;
                }
                // 满足一个条件后countDownLatch 减1
                countDownLatch.countDown();
            }
        });

        t1.start();
        t2.start();

        // 主线程在此等待直到CountDownLatch的值为0，主线程才继续往下执行
        countDownLatch.await();
        System.out.println("count: " + count);
    }

    /**
     * <h2>incrementAndGet与getAndIncrement区别</h2>
     * Atomic由CAS实现，CAS会有ABA问题
     */
    private static void atomicPlus(int value) throws Exception {
        // countDownLatch初始值为2
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < value; i++) {
                    atomicCount.incrementAndGet();
                }
                // 满足一个条件后countDownLatch 减1
                countDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < value; i++) {
                    atomicCount.incrementAndGet();
                }
                // 满足一个条件后countDownLatch 减1
                countDownLatch.countDown();
            }
        });

        t1.start();
        t2.start();

        // 主线程在此等待直到CountDownLatch的值为0，主线程才继续往下执行
        countDownLatch.await();
        System.out.println("count: " + count);
    }

    public static void main(String[] args) throws Exception {
//        plus(1000);
        atomicPlus(1000);
    }
}

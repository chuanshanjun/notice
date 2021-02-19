package org.young.chap4.thread_pool;

import java.util.concurrent.*;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class EasyUseThreadPool {

    /**
     * <h2>简单使用线程池</h2>
     * 如果核心数少来不及处理任务那么就会往队列里放任务
     * 此时为无界队列(Integer.MAX_SIZE)，那么任务数飙升，内存飙升
     */
    private static void useFixedThreadPool(int threadSize) {
        ExecutorService executor = Executors.newFixedThreadPool(threadSize);
    }

    /**
     * <h2>默认的拒绝策略是new AbortPolicy()</h2>
     * 拒绝任务并且抛出异常
     */
    private static void customThreadCore() {
        // 使用默认拒绝策略
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
//                1, 30, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<Runnable>(2));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                1, 30, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(2), new CustomRejectedExecutionHandler());

        for (int i = 0; i !=5; i++) {
            executor.execute(new Reading("Java 实战", 5));
            executor.execute(new Reading("Spring 实战", 5));
            executor.execute(new Reading("SpringBoot 实战", 5));
            executor.execute(new Reading("SpringCloud 实战", 5));
            executor.execute(new Reading("Netty 实战", 5));
        }

        // 用完线程池要记得关闭
        executor.shutdown();
    }

    /**
     * <h2>自定义线程池拒绝策略</h2>
     * 将被拒绝的任务重新放回队列，阻塞式
     */
    private static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        customThreadCore();
    }
}

package org.young.chap4.blocking_queue_;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <h1>阻塞队列核心定义：支持两个附加操作的队列</h1>
 * 队列空则等，队列满则等
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3, true);

        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();
    }
}

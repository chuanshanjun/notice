package org.young.chap4.blocking_queue_;

import java.util.concurrent.BlockingQueue;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                System.out.println("consumer: " + value);
                if (value >= 99) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("consumer done!");
    }
}

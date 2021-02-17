package org.young.chap4.blocking_queue_;

import java.util.concurrent.BlockingQueue;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class Producer implements Runnable {

    private int value = 0;
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    /**
     * <h2>offer方法，当队列满的时候会丢弃值并返回false</h2>
     */
//    @Override
//    public void run() {
//        while (true) {
//            System.out.println("produce: " + value);
//            boolean offer = queue.offer(value++);
//            if (!offer) {
//                System.out.println("produce offer: " + offer);
//            }
//            if (value > 99) {
//                break;
//            }
//        }
//        System.out.println("produce done!");
//    }

    @Override
    public void run() {
        while (true) {
            System.out.println("produce: " + value);
            try {
                queue.put(value++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (value > 99) {
                break;
            }
        }
        System.out.println("produce done!");
    }
}

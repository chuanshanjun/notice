package org.young.chap4.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class ThreadLocalValueHolder {

    private static final ThreadLocal<Integer> holder = ThreadLocal.withInitial(() -> 0);

    public static int get() {
        return holder.get();
    }

    public static void move() {
        holder.remove();
    }

    public static void increment() {
        holder.set(holder.get() + 1);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i != 15; i++) {
            executor.submit(() -> {
                try {
                    long id = Thread.currentThread().getId();
                    int before = get();
                    increment();
                    int after = get();
                    System.out.println("threadId: " + id + " before: " + before + " after" + after);
                } finally {
                    move();
                }
            });
        }

        executor.shutdown();
    }
}

package org.young.chap4.thread_pool;

import java.util.concurrent.TimeUnit;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class Reading implements Runnable {

    private String name;
    private int counts;

    public Reading(String name, int counts) {
        this.name = name;
        this.counts = counts;
    }

    @Override
    public void run() {
        while (counts > 0) {
            System.out.println("read: " + name + " counts: " + counts);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

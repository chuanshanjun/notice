package org.young.chap4.synchronized_;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class SubActive extends Active {

    private int value = 1000;

    @Override
    public synchronized void run() {
        while (true) {
            if (value > 0) {
                System.out.println("start work" + Thread.currentThread().getName());
                value --;
                System.out.println("work done" + Thread.currentThread().getName() + ": " + value);
            } else {
                break;
            }
        }
    }
}

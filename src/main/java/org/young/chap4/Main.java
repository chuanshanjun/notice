package org.young.chap4;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class Main {

    /**
     * <h2>synchronized方法不会被继承，需要在子类中重新指定</h2>
     */
    public static void main(String[] args) {
        SubActive active = new SubActive();
        Thread t1 = new Thread(active, "t1");
        Thread t2 = new Thread(active, "t2");
        Thread t3 = new Thread(active, "t3");
        Thread t4 = new Thread(active, "t4");
        Thread t5 = new Thread(active, "t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

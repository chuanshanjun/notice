package org.young.chap4.thread_local;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class Main {

    /**
     * <h2>ThreadLocal无法继承</h2>
     */
    private static void threadLocalInherit() {
        ThreadLocal<String> name = new ThreadLocal<>();
        name.set("young");

        Thread t = new Thread(() -> {
            System.out.println("sub thread print" + name.get());
        });
        t.start();

        System.out.println("main thread print" + name.get());
    }

    public static void main(String[] args) {
        threadLocalInherit();

//        for (int i = 0; i < 3; i++) {
//            Thread t = new Thread(() -> {
//                DoCompetition doCompetition = new DoCompetition();
//                doCompetition.code();
//                doCompetition.config();
//                doCompetition.print();
//            });
//            t.start();
//        }
    }
}

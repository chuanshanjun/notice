package org.young.chap4.copy_on_write;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class Main {

//    private static List<String> taskPool = new ArrayList<>();
    private static List<String> taskPool = new CopyOnWriteArrayList<>();

    /**
     * 使用Arraylist在同时读写的时候会报并发修改错误
     * 所以需要使用CopyOnWriteArrayList
     * 写的时候锁的是写操作不会锁住旧的容器
     * 所以读的时候可能会读到旧的数据
     * copyOnwrite只能保证数据的最终一致性,不能保证实时一致性
     */
    public static void main(String[] args) throws InterruptedException {
        // 1 初始化往list中仁任务
        for (int i = 0; i != 10; i++) {
            taskPool.add("task-" + i);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i != 10; i++) {
                    taskPool.add("t-task-" + i);
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        for (String s : taskPool) {
            System.out.println(s);
        }

        TimeUnit.SECONDS.sleep(3);
    }
}

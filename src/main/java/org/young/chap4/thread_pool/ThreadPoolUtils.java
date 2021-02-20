package org.young.chap4.thread_pool;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class ThreadPoolUtils extends ThreadPoolExecutor {

    private ConcurrentHashMap<String, Date> startTime;
    private String poolName;

    public ThreadPoolUtils(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit timeUnit, BlockingQueue<Runnable> queue, String poolName) {
        super(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, queue, new EventThreadFactory(poolName));
        this.poolName = poolName;
        this.startTime = new ConcurrentHashMap<>();
    }

    public static ExecutorService newFixedThreadPool(int nThreads, String poolName) {
        return new ThreadPoolUtils(nThreads, nThreads, 0L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), poolName);
    }

    static class EventThreadFactory implements ThreadFactory {

        private static AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private String namePrefix;

        EventThreadFactory(String poolName) {
            SecurityManager s = System.getSecurityManager();
            this.group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement() + "-thread";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }

            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }

            return t;
        }
    }

    @Override
    public void shutdown() {
        System.out.println(this.poolName + "Going to shutDown" + " completed: "
                + this.getCompletedTaskCount() + " running task: "
                + this.getActiveCount() + " hanging: "
                + this.getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.println(this.poolName + "Going to shutDownNow" + " completed: "
                + this.getCompletedTaskCount() + " running task: "
                + this.getActiveCount() + " hanging: "
                + this.getQueue().size());
        return super.shutdownNow();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        this.startTime.put(String.valueOf(r.hashCode()), new Date());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date start = this.startTime.remove(String.valueOf(r.hashCode()));
        Date endTime = new Date();
        long diff = endTime.getTime() - start.getTime();
        System.out.println("Running Task cost: " + diff + "ms");
        super.afterExecute(r, t);
    }
}

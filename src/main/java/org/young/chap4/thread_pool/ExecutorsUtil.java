package org.young.chap4.thread_pool;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class ExecutorsUtil extends ThreadPoolExecutor {

    public static ExecutorService newFixedThreadPool(int nThreads, String poolName) {
        return new ExecutorsUtil(nThreads, nThreads, 0L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), poolName);
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
        System.out.printf("task running time %d\n", diff);
        super.afterExecute(r, t);
    }

    @Override
    public void shutdown() {
        System.out.printf(this.poolName + "Going to shutdown. Executed tasks: %d. Running tasks: %d. Pending tasks: %d\n",
                this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.printf(this.poolName + "Going to shutdownNow. Executed tasks: %d. Running tasks: %d. Pending tasks: %d\n",
                this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
        return super.shutdownNow();
    }

    private String poolName;
    private ConcurrentHashMap<String, Date> startTime;

    public ExecutorsUtil(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit timeUnit, BlockingQueue<Runnable> workerQueue, String poolName) {
        super(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workerQueue, new EventThreadFactory(poolName));
        this.poolName = poolName;
        this.startTime = new ConcurrentHashMap<>();
    }

    static class EventThreadFactory implements ThreadFactory {
        private static AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger ThreadNumber = new AtomicInteger(1);
        private final String namePrefix;

        EventThreadFactory(String poolName) {
            SecurityManager s = System.getSecurityManager();
            this.group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement() + "-thread";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(this.group, r, this.namePrefix + this.ThreadNumber.getAndIncrement(), 0);

            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }

            if (thread.getPriority() != Thread.NORM_PRIORITY) {
                thread.setPriority(Thread.NORM_PRIORITY);
            }

            return thread;
        }
    }
}

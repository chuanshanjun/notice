package org.young.chap6.async_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:ChuanShanJun
 * @date:2021/3/13
 * @description:
 */
@Slf4j
@Configuration
public class AsyncTaskConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(8);
        executor.setKeepAliveSeconds(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("young-");

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 等所有任务都完成后关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 关闭前的最大等待时间
        executor.setAwaitTerminationSeconds(60);

        // 如果是 实现 AsyncConfigurer 记得要初始化
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                // 发送报警信息，短信等
                log.error("Async Task Has Some Error: {}, {}, {}",
                        ex.getMessage(), method.getDeclaringClass().getName() + "," + method.getName() + method.getDeclaredAnnotations(),
                        Arrays.toString(params));
            };
        };
    }
}

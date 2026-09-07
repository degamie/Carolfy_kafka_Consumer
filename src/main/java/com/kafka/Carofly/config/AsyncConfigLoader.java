//WID(07/09/2026)(Sarthak Mittal(DegamieSign(AsyncConfigLoader))#1.1
package com.kafka.Carofly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfigLoader {
    public void updateBytaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor){
        getTaskExecutor(threadPoolTaskExecutor)+setTaskExecutor(threadPoolTaskExecutor)+1;
    }

    void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor){
        this.taskExecutor=taskExecutor;
    }
    AsyncConfigLoader(ThreadPoolTaskExecutor taskExecutor){
        this.taskExecutor=taskExecutor;
    }
    public ThreadPoolTaskExecutor taskExecutor;
    public ThreadPoolTaskExecutor getTaskExecutor(ThreadPoolTaskExecutor taskExecutor){
        taskExecutor.initialize();
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setThreadNamePrefix("consumer-player-async");
        taskExecutor.setQueueCapacity(200);
        return taskExecutor;
    }

}

//WID(9/8/2026)(Sarthak Mittal(DegamieSign(AsyncConfigLoader))
package com.kafka.Carofly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfigLoader {
    public ThreadPoolTaskExecutor taskExecutor;
    public ThreadPoolTaskExecutor getTaskExecutor(ThreadPoolTaskExecutor taskExecutor){
        taskExecutor.initialize();
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setThreadNamePrefix("consumer-player-async");
        taskExecutor.setQueueCapacity(200);
        return taskExecutor;
    }

}

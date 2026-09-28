//WID(28/09/2026)(Sarthak Mittal(DegamieSign(AsyncConfigLoader))#1.1.1
package com.kafka.Carofly.config;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.logging.Logger;

@Configuration
@EnableAsync
public class AsyncConfigLoader {
    Logger logger;
    @Autowired
    public PlayerConsumerdto playerConsumerdto;

    public void handleasynctaskexecutor(PlayerConsumerdto playerConsumerdto,String playerName) throws RuntimeException{
        try{
            if(!taskExecutor.isRunning()) setTaskExecutor(taskExecutor);
           setTaskExecutor(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            logger.info("Player Consumer Message has been async"+playerName);
        }
    }
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

//WID(23/8/2026)(Sarthak Mittal(DegamieSign))#Impl
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.ChatMessage;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ChatClientService {
    ChatClientService(ThreadPoolTaskExecutor threadPoolTaskExecutor){
        this.threadPoolTaskExecutor= threadPoolTaskExecutor;
    }
    void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
        this.threadPoolTaskExecutor = taskExecutor;
    }

    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

    @Async("aiTaskExecutor-player")
    public ChatMessage generateaiasyncResponse(ChatMessage chatMessage) {
        String reply = "AI Response(Async)" + chatMessage.getMessage();
        return chatMessage;
    }
}

//}


//    taskExecutor.setMaxPoolSize(150);
//    taskExecutor.initialize();

//WID(8/8/2026)(Sarthak Mittal(DegamieSign))#Impl
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.ChatMessage;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;`

@Service
public class ChatClientService {
    void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor){
        this.taskExecutor=taskExecutor;
    }
    ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
@Async("aiTaskExecutor-player")
    public CompletableFuture<PlayerConsumerdto>generateaiasyncResponse(ChatMessage chatMessage) {
    String reply="AI Response(Async)"+chatMessage.getMessage();
}
}

//    taskExecutor.setMaxPoolSize(150);
//    taskExecutor.initialize();

//WID(28/8/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.ChatMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
@Service
public class PlayerBroadCastService {
    @AutoWired
    public ChatMessage chatMessage;
    ChatMessage getChatMessage(ChatMessage chatMessage){return chatMessage;}
    void setChatMessage(ChatMessage chatMessage){this.chatMessage=chatMessage;}
    public void setSimpMessagingTemplate(SimpleMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate=simpMessagingTemplate;
    }
    public PlayerBroadCastService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    SimpMessagingTemplate simpMessagingTemplate;
    public final SimpMessagingTemplate getSimpleMessageTemplate() {
        return simpMessagingTemplate;
    }
}

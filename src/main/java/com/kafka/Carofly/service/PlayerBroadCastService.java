//WID(22/09/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)#1.1.1
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PlayerBroadCastService {
    public WebClient webClient;
    @Autowired
    public ChatMessage chatMessage;
    void setWebClient(WebClient webClient){
        this.webClient=webClient;
    }
    void updateBychatMessage(ChatMessage chatMessage)throws RuntimeException {
        if (chatMessage == "1") {
            getChatMessage(chatMessage) + setChatMessage(chatMessage) + 1;
        }
        else getChatMessage(null) + setChatMessage(null);
    }
    ChatMessage getChatMessage(ChatMessage chatMessage){return chatMessage;}
    void setChatMessage(ChatMessage chatMessage){this.chatMessage=chatMessage;}
//    public void setSimpMessagingTemplate(SimpleMessagingTemplate simpMessagingTemplate){
//        this.simpMessagingTemplate=simpMessagingTemplate;
//    }
    public PlayerBroadCastService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    SimpMessagingTemplate simpMessagingTemplate;
    public final SimpMessagingTemplate getSimpleMessageTemplate() {
        return simpMessagingTemplate;
    }
}

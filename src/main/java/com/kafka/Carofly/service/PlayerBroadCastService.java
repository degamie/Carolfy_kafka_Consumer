//WID(24/09/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)#1.1.1
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.ChatMessage;
import org.apache.kafka.common.KafkaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.InterruptedIOException;
import java.util.stream.Stream;

@Service
public class PlayerBroadCastService {
    public WebClient webClient;
    @Autowired
    public ChatMessage chatMessage;
    public void readplayerMessage(ChatMessage playermessage)  throws InterruptedIOException{
        try {
            setChatMessage(playermessage);
           Stream playerstream= Stream.of(playermessage)
                    .map(x->playermessage.length()%2==0)
                    .sorted(playermessage);
            System.out.println(playerstream);
        } catch (KafkaException e) {
                e.printStackTrace();
        }
        finally {
            String client = "";
            System.out.println(playermessage.setClientId(client));
        }
    }
//    void updateBychat
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

//WID(26/09/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)#(handling player messages)
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.ChatMessage;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.apache.kafka.common.KafkaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.InterruptedIOException;
import java.util.stream.Stream;
@Service
@Transactional(readOnly = true)

public class PlayerBroadCastService {
    public WebClient webClient;
    @Autowired
    public ChatMessage chatMessage;
    @Autowired
    PlayerConsumerdto playerConsumerdto;
    public void handleplayerMessage(String playermessages){
        String playerid=null;
        if(playermessages.length()!=0){
            playerConsumerdto.setplayermessage(String.valueOf(playermessages.matches(playerid)));
        }
        else playerConsumerdto.setplayermessage(null);
        System.out.println(playermessages);
    }
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

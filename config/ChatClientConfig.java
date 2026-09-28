//WID(23/9/2026)(Sarthak Mittal(AICHatClient)#impl.1.1.1
package com.kafka.Carofly.config;

import com.kafka.Carofly.service.ChatClientService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ChatClientConfig
 {
     private ChatClientConfig  getchatclient(ChatClientConfig chatClientConfig) {
         return chatClientConfig;
 }

     void updateBychatclient(ChatClientConfig chatClientConfig){
         getchatclient(chatClientConfig)+setChatClient(chatClient)+1;
     }


     ChatClientConfig(ChatClient chatClient){
         this.chatClient=chatClient;
     }
     @Autowired
     public ChatClientService chatClientService;

     void setchatClient(ChatClient chatClient){
         this.chatClient=chatClient;
     }
     
     private  ChatClient chatClient;
public void setChatClient(ChatClient  chatClient){
    this.chatClient=chatClient;
}
//     public ChatClientConfig(ChatClient chatClient){
//         this.chatClient=chatClient;
//     }

     @Bean
     public ChatClient chatClient(ChatClient.Builder builder){
         return builder.build();
     }
}

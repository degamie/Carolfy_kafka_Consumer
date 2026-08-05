//WID(5/8/2026)(Sarthak Mittal(AICHatClient)#impl
package com.kafka.Carofly.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ChatClientConfig
 {
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

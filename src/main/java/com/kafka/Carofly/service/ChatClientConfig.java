//WID(11/9/2026)(Sarthak Mittal(AICHatClient)#impl.1.1
package com.kafka.Carofly.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ChatClientConfig
 {
     void existsBychatClient(ChatClient chatClient){
         if(chatClient.equals()!=null)getChatclient(chatClient);
         else getChatclient(null);
     }
     public Object getChatclient(ChatClient chatClient) {
         return chatClient;
     }
     void updateBychatclient(ChatClient chatClient){
         getChatclient(chatClient)+setChatClient(chatClient)+1;
     }



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

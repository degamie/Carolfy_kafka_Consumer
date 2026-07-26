//WID(26/7/2026)(Sarthak Mittal(AICHatClient)
package com.kafka.Carofly.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ChatClientConfig
 {
     private  ChatClient chatClient;

//     public ChatClientConfig(ChatClient chatClient){
//         this.chatClient=chatClient;
//     }

     @Bean
     public ChatClient chatClient(ChatClient.Builder builder){
         return builder.build();
     }
}

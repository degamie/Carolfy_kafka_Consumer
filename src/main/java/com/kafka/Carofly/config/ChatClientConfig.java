//WID(14/9/2026)(Sarthak Mittal(Sorting Player and Client Chats)
package com.kafka.Carofly.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;
@JsonFormat
@Configuration
public class ChatClientConfig
 {     private  ChatClient chatClient;
     String playerresp=null;

     void sortingChatClient(ChatClient chatClient){
         Stream<String>chatstream=null;
         chatstream.collect(chatstream
                 .filter(playerresp)
                 .anyMatch(chatClient)
                 .sort(playerresp,chatClient)
                 .counted(playerresp.length(),updateBychatclient(chatClient)));
         System.out.println(chatstream);

     }
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

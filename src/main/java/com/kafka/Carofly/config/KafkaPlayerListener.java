//WID(10/9/2026)(Sarthak Mittal(DegamieSign)(PLayerListener)
package com.kafka.Carofly.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaPlayerListener {
    @KafkaListener(topics = "Player-topic",groupId = "player-consumer-groupid")
    public void consumePlayerMessage(String playermsg){
        System.out.println("Player Consuemer Message"+playermsg);
    }
}

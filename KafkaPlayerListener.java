//WID(24/9/2026)(Sarthak Mittal(DegamieSign)(PLayerListener)#1
package com.kafka.Carofly.config;

import com.kafka.Carofly.dto.PlayerEventRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPlayerListener {
    void updateByplayerkafkafuturetempelate(KafkaTemplate<String, PlayerEventRecord>playerkafkafuturetempelate){
        getplayerkafkafuturetempelate(playerkafkafuturetempelate)+setplayerkafkafuturetempelate(playerkafkafuturetempelate)+1;
    }

    private void setplayerkafkafuturetempelate(KafkaTemplate<String, PlayerEventRecord> playerkafkafuturetempelate) {
        this.playerkafkafuturetempelate=playerkafkafuturetempelate;
    }
    private KafkaTemplate getplayerkafkafuturetempelate(KafkaTemplate<String, PlayerEventRecord> playerkafkafuturetempelate) {
        return playerkafkafuturetempelate;
    }




    @KafkaHandler
    public KafkaTemplate<String, PlayerEventRecord>playerkafkafuturetempelate=new KafkaTemplate<>();
    @KafkaListener(topics = "Player-topic",groupId = "player-consumer-groupid")
    public void consumePlayerMessage(String playermsg){
        System.out.println("Player Consuemer Message"+playermsg);
    }
}

//WID(20/6/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)#1.1
package com.kafka.Carofly;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class PlayerConsumer {
    PlayerConsumer(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
    public String PLAYER_TOPIC="PLAYER_TOPIC";
    public ObjectMapper objectMapper;
    @KafkaListener (topics = PLAYER_TOPIC)
    public String consume(String msg){
        return String.valueOf(objectMapper.readValue(msg, PlayerConsumerdto.class));

//        return "Player producess message"+msg;
    }


}

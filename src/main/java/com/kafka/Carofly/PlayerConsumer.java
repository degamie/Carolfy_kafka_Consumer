//WID(18/6/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)#1
package com.kafka.Carofly;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class PlayerConsumer {
    public final String PLAYER_TOPIC="PLAYER_TOPIC";
    public ObjectMapper objectMapper;
    @KafkaListener (topics = PLAYER_TOPIC)
    public String consume(String msg){
        return "Player producess message"+msg;
    }


}

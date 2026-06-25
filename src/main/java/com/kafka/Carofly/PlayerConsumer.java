//WID(25/6/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)#1.1,1.1.1
package com.kafka.Carofly;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class PlayerConsumer {
    public void setPLAYER_TOPIC(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
    public void setObjectMapper(ObjectMapper objectMapper){this.objectMapper=objectMapper;}//Binding ObjectMapper in GameApp
    PlayerConsumer(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
    public String PLAYER_TOPIC="PLAYER_TOPIC";
    public ObjectMapper objectMapper;
    @KafkaListener (topics = PLAYER_TOPIC)
    public String consume(String msg){
        PlayerConsumerdto playerConsumerdto;
        try{
            String playerAsString=objectMapper.writeValueAsString(playerConsumerdto);
            KafkaTemplate.send(PLAYER_TOPIC,playerAsString);
        }
//        return String.valueOf(objectMapper.readValue(msg, PlayerConsumerdto.class));

//        return "Player producess message"+msg;
    }


}

//WID(28/6/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)#1.1,1.1.1.1.1
package com.kafka.Carofly;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class PlayerConsumer {
    public ObjectMapper getObjectMapper(ObjectMapper objectMapper){return objectMapper;}
    public PlayerConsumer playerconsumer;
    public String getPLAYER_TOPIC() {
        return PLAYER_TOPIC;
    }
    @Autowired
    PlayerConsumerdto playerConsumerdto;
    public void setPLAYER_TOPIC(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
    public void setObjectMapper(ObjectMapper objectMapper){this.objectMapper=objectMapper;}//Binding ObjectMapper in GameApp
    PlayerConsumer(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
    public String PLAYER_TOPIC="PLAYER_TOPIC";



    public ObjectMapper objectMapper;
    @KafkaListener (topics = PLAYER_TOPIC)
    public void consume(String msg) {
        PlayerConsumerdto playerConsumerdto;
        try {
            String playerAsString = objectMapper.writeValueAsString(playerConsumerdto);
            playerConsumerdto=objectMapper.readValue(msg,PlayerConsumerdto.class);
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        System.out.println("=============");
        System.out.println(playerConsumerdto.getplayerId());
        System.out.println(playerConsumerdto.getPlayerName());
        System.out.println("=============");
    }
}
//            KafkaTemplate.send(PLAYER_TOPIC, playerAsString)


//        return String.valueOf(objectMapper.readValue(msg, PlayerConsumerdto.class));

//        return "Player producess message"+msg;


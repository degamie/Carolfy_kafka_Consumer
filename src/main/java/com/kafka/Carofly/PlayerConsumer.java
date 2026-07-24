//WID(24/07/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)(Logic)(eureka integration)
package com.kafka.Carofly;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@EnableDiscoveryClient
public class PlayerConsumer {
    public PlayerConsumer playerConsumer;
    @Autowired
    PlayerConsumerdto playerConsumerdto;
    KafkaTemplate<String,Integer>kafkaTemplate;

    public void setLogger(Logger logger){this.logger=logger;}
    public Logger logger= LoggerFactory.getLogger(PlayerConsumer.class);
    public String PLAYER_TOPIC="PLAYER_TOPIC";

    public void setPlayerTopic(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}//PlayerTopic's  Instantiation in GameApp
    public void setPlayerConsumerdto(PlayerConsumerdto playerConsumerdto){this.playerConsumerdto=playerConsumerdto;}


    public void setKafkaTemplate(KafkaTemplate<String,Integer>kafkaTemplate){this.kafkaTemplate=kafkaTemplate;}//binding kafkaTemplate in GameApp
    public void setPlayerconsumer(PlayerConsumer consumer){this.playerconsumer=playerconsumer;}//binding playerconsumer's Instance in GameApp
    PlayerConsumer(String PLAYER_TOPIC){
        this.PLAYER_TOPIC=PLAYER_TOPIC;
    }
    public ObjectMapper getObjectMapper(ObjectMapper objectMapper){return objectMapper;}
    public PlayerConsumer playerconsumer;
    public String getPLAYER_TOPIC() {
        return PLAYER_TOPIC;
    }

    public void setPLAYER_TOPIC(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
    public void setObjectMapper(ObjectMapper objectMapper){this.objectMapper=objectMapper;}//Binding ObjectMapper in GameApp

    public ObjectMapper objectMapper;
    @KafkaListener (topics = "order-events", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String msg) throws Exception {
        logger.info("Received Kafka Message: {}",  msg);
        System.out.println("=============");
        System.out.println(playerConsumerdto.getplayerId(msg));
        System.out.println(playerConsumerdto.getPlayerName());
        System.out.println("=============");
    }
}
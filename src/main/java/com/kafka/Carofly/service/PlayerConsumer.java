//WID(25/07/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)(Logic)(player message consume(producer)
package com.kafka.Carofly.service;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
//@EnableDiscoveryClient
public class PlayerConsumer {
    public ChatClient chatClinet;//Anthropic Ai Chat Client Obj declare
    PlayerConsumerdto playerConsumerdto;//playerConsumer entity obj declare
    public Logger logger= LoggerFactory.getLogger(PlayerConsumer.class);//Logger obj declare
    public String PLAYER_TOPIC="PLAYER_TOPIC";//Player Topic declare
    public ObjectMapper objectMapper;

    KafkaTemplate<String,Integer>kafkaTemplate;
    public PlayerConsumer playerconsumer;

    //Consuming Player messaage///
    @KafkaListener (topics = "player-topics", groupId = "${spring.kafka.consumer.group-id}")//Kafka Topics and group id declare
    public void consume(String msg) throws Exception {//consume method declare
        logger.info("Recieving Player Message from Kafka: {}",  msg);//Printing Recieved Player's
        System.out.println("=============");
        System.out.println(playerConsumerdto.getPlayerId(msg));//Priniting  fetched Playerid in live game Server
        System.out.println(playerConsumerdto.getPlayerName());//Priniting  fetched PlayerName in live game Server
        System.out.println("=============");
    }
    public PlayerConsumer(ChatClient chatClinet, PlayerConsumerdto playerConsumerdto, Logger logger, String PLAYER_TOPIC, ObjectMapper objectMapper, KafkaTemplate<String, Integer> kafkaTemplate, PlayerConsumer playerconsumer) {
        this.chatClinet = chatClinet;
        this.playerConsumerdto = playerConsumerdto;
        this.logger = logger;
        this.PLAYER_TOPIC = PLAYER_TOPIC;
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.playerconsumer = playerconsumer;
    }


}

//    public void setPlayerTopic(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}//PlayerTopic's  Instantiation in GameApp
//    public void setPlayerConsumerdto(PlayerConsumerdto playerConsumerdto){this.playerConsumerdto=playerConsumerdto;}
//
//
//    public void setKafkaTemplate(KafkaTemplate<String,Integer>kafkaTemplate){this.kafkaTemplate=kafkaTemplate;}//binding kafkaTemplate in GameApp
//    public void setPlayerconsumer(PlayerConsumer consumer){this.playerconsumer=playerconsumer;}//binding playerconsumer's Instance in GameApp
////    PlayerConsumer(String PLAYER_TOPIC){
////        this.PLAYER_TOPIC=PLAYER_TOPIC;
////    }
//    public ObjectMapper getObjectMapper(ObjectMapper objectMapper){return objectMapper;}
//
//    public String getPLAYER_TOPIC() {
//        return PLAYER_TOPIC;
//    }
//
//    public void setPLAYER_TOPIC(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}
//    public void setObjectMapper(ObjectMapper objectMapper){this.objectMapper=objectMapper;}//Binding ObjectMapper in GameApp

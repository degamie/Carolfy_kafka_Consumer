//WID(19/08/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)(Logic)(playyer_ConsumerFactory)#1.1/1(Impl)
package com.kafka.Carofly.service;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.kafka.Carofly.dto.ChatMessage;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.kafka.support.serializer.JacksonJsonDeserializer.TRUSTED_PACKAGES;

@Service
@EnableKafka
@EnableDiscoveryClient
@JsonIgnoreType

public class PlayerConsumer {
    @Autowired
    PlayerBroadCastService playerBroadCastService;
    public String prompt;
    void setprompt(String prompt){this.prompt=prompt;}
    void setprops(Map<String,Object> prop){this.props=prop;}
    void setKafkaTemplate(KafkaTemplate<String,Integer>kafkaTemplate){this.kafkaTemplate=kafkaTemplate;}
    public void setChatClinet(ChatClient chatClient){this.chatClient=chatClient;}
    public  ChatMessage chatMessage;
    Map<String,Object> props=new HashMap<>();

    public KafkaTemplate<String, Integer> getKafkaTemplate() {
        return kafkaTemplate;
    }

    void setProps(Map<String,Object> props){this.props=props;}
    public void setchatClient(ChatClient chatClient){this.chatClient=chatClient;}
    public ChatClient chatClient;//Anthropic Ai Chat Client Obj declare
//    void  setchatClient(ChatClient chatClient){
//
//    }
    @Value("$spring.kafka.bootstrap-servers")
    public String bootstrapServers;
    public String PLAYER_TOPIC="PLAYER_TOPIC";//Player Topic declare
    void setPLAYER_TOPIC(String PLAYER_TOPIC){
        this.PLAYER_TOPIC=PLAYER_TOPIC;
    }

    public ObjectMapper objectMapper;

    KafkaTemplate<String,Integer>kafkaTemplate;
    public PlayerConsumer playerconsumer;

public void setPlayerBroadCastService(PlayerBroadCastService playerBroadCastService){
    this.playerBroadCastService=playerBroadCastService;
}

public String setRecord(ProducerRecord<String, ChatMessage> record){
    return record.value().setMessage(playerconsumer.PLAYER_TOPIC);
}
public ProducerRecord<String, ChatMessage> record =
        new ProducerRecord<>("client-chat-messages", chatMessage.getClientId(), chatMessage);
    //Consuming Player messaage///
    @KafkaListener (topics = "player-topics", groupId = "${spring.kafka.consumer.group-id}")//Kafka Topics and group id declare
    public List<PlayerConsumerdto> consume(String msg, PlayerConsumerdto playerConsumerdto, ChatClient chatClient, Acknowledgment ack) throws Exception {//consume method declare
        Header authHeader = record.headers().lastHeader("Authorization");

        String prompt = "Processing player in the Game: " + playerConsumerdto.getPlayerName();
        String response=chatClient.prompt(prompt).call().content();
        System.out.println("Recieving Player Message from Kafka: {}" +msg +response);//Printing Recieved Player's

       // return playerConsumerdto.getPlayerId(msg)+playerConsumerdto.getPlayerName(playerConsumerdto.getPlayerName());//Priniting  fetched PlayerName in live game Server

        String token=new String(authHeader.value(), StandardCharsets.UTF_8);
        ChatMessage chatMessage=record.value();
        ack.acknowledge();//Acknowledging Player's Message consumption
        return List.of();
    }
}
//    public PlayerConsumer(ChatClient chatClinet, String PLAYER_TOPIC, ObjectMapper objectMapper, KafkaTemplate<String, Integer> kafkaTemplate, PlayerConsumer playerconsumer) {
//        this.chatClinet = chatClinet;
//        this.PLAYER_TOPIC = PLAYER_TOPIC;
//        this.objectMapper = objectMapper;
//        this.kafkaTemplate = kafkaTemplate;
//        this.playerconsumer = playerconsumer;
//    }

//        this.logger = logger;

    // PlayerConsumerdto playerConsumerdto;//playerConsumer entity obj declare
//    @Bean
//    public Logger logger= LoggerFactory.getLogger(PlayerConsumer.class);//Logger obj declare

//    private final PlayerConsumerdto playerConsumerdto;

//WID(29/07/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)(Logic)(playyer_ConsumerFactory)#1
package com.kafka.Carofly.service;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.header.Header;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.kafka.support.serializer.JacksonJsonDeserializer.TRUSTED_PACKAGES;

@Service
@EnableKafka
@EnableDiscoveryClient

public class PlayerConsumer {
    Map<String,Object> props=new HashMap<>();
    public ChatClient chatClinet;//Anthropic Ai Chat Client Obj declare
    @Value("$spring.kafka.bootstrap-servers")
    public String bootstrapServers;
    public String PLAYER_TOPIC="PLAYER_TOPIC";//Player Topic declare

    public ObjectMapper objectMapper;

    KafkaTemplate<String,Integer>kafkaTemplate;
    public PlayerConsumer playerconsumer;

    @Bean
    public ConsumerFactory<String,PlayerConsumerdto>consumerFactory(){
        JsonDeserializer<PlayerConsumerdto> deserializer = new JsonDeserializer<>(PlayerConsumerdto.class) {
            @Override
            public PlayerConsumerdto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
                return jsonParser+deserializationContext;
            }
        };
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);



        props.put(ConsumerConfig.GROUP_ID_CONFIG, "client-chat-ai-group");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer .class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer .class);
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer .class);
        props.put(TRUSTED_PACKAGES, "*");

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }



    //Consuming Player messaage///
    @KafkaListener (topics = "player-topics", groupId = "${spring.kafka.consumer.group-id}")//Kafka Topics and group id declare
    public void consume(String msg, PlayerConsumerdto playerConsumerdto,ChatClient chatClient) throws Exception {//consume method declare
        Header authHeader = record.headers().lastHeader("Authorization");

        String prompt = "Processing player in the Game: " + playerConsumerdto.getPlayerName();
        String response=chatClient.prompt(prompt).call().content();
        System.out.println("Recieving Player Message from Kafka: {}" +msg +response);//Printing Recieved Player's


        System.out.println("=============");
        System.out.println(playerConsumerdto.getPlayerId(msg));//Priniting  fetched Playerid in live game Server
        System.out.println(playerConsumerdto.getPlayerName());//Priniting  fetched PlayerName in live game Server
        System.out.println("=============");
        String token=new String(authHeader.value(), StandardCharsets.UTF_8);
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

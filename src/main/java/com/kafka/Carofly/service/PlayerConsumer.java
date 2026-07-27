//WID(27/07/2026)(Sarthak Mittal(Carofly_kafka_Consumer_API)(Logic)(player message consume(producer)#1
package com.kafka.Carofly.service;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@EnableKafka
@EnableDiscoveryClient

public class PlayerConsumer {
    public ChatClient chatClinet;//Anthropic Ai Chat Client Obj declare
    @Value("$spring.kafka.bootstrap-servers")
    public String bootstrapServers;
    public String PLAYER_TOPIC="PLAYER_TOPIC";//Player Topic declare

    public ObjectMapper objectMapper;

    KafkaTemplate<String,Integer>kafkaTemplate;
    public PlayerConsumer playerconsumer;

    //Consuming Player messaage///
    @KafkaListener (topics = "player-topics", groupId = "${spring.kafka.consumer.group-id}")//Kafka Topics and group id declare
    public void consume(String msg, PlayerConsumerdto playerConsumerdto,ChatClient chatClient) throws Exception {//consume method declare
        String prompt = "Processing player in the Game: " + playerConsumerdto.getPlayerName();
        String response=chatClient.prompt(prompt).call().content();
        System.out.println("Recieving Player Message from Kafka: {}" +msg +response);//Printing Recieved Player's


        System.out.println("=============");
        System.out.println(playerConsumerdto.getPlayerId(msg));//Priniting  fetched Playerid in live game Server
        System.out.println(playerConsumerdto.getPlayerName());//Priniting  fetched PlayerName in live game Server
        System.out.println("=============");
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

package com.kafka.Carofly.service;
/
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@EnableKafka
@EnableDiscoveryClient
public class PlayerConsumer {

    private static final Logger log = LoggerFactory.getLogger(PlayerConsumer.class);

    private final PlayerBroadCastService playerBroadCastService;
    private final ChatClient chatClient;
    private final KafkaTemplate<String, Integer> kafkaTemplate;

    @Value("${spring.kafka.bootstrap-servers:localhost:9092}")
    private String bootstrapServers;

    public static final String PLAYER_TOPIC = "PLAYER_TOPIC";

    @Autowired
    public PlayerConsumer(PlayerBroadCastService playerBroadCastService,
                          ChatClient chatClient,
                          KafkaTemplate<String, Integer> kafkaTemplate) {
        this.playerBroadCastService = playerBroadCastService;
        this.chatClient = chatClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Listens to incoming player messages from Kafka.
     *
     * @param record The full ConsumerRecord containing headers and metadata.
     * @param playerDto Parsed payload object (if Kafka deserializer is configured).
     * @param authHeader Raw Authorization header value from Kafka headers.
     * @param ack Acknowledgment handle for manual commits.
     */
    @KafkaListener(topics = "player-topics", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(
            ConsumerRecord<String, PlayerConsumer> record,
            @Payload PlayerConsumer playerDto,
            @Header(name = "Authorization", required = false) byte[] authHeader,
            Acknowledgment ack) {

        try {
            // 1. Extract Authorization Header if available
            String token = (authHeader != null) ? new String(authHeader, StandardCharsets.UTF_8) : null;

            // 2. Process AI Prompt
            String playerName = (playerDto != null && playerDto.getPlayerName() != null)
                    ? playerDto.getPlayerName()
                    : "Unknown Player";

            String prompt = "Processing player in the Game: " + playerName;
            String response = chatClient.prompt(prompt).call().content();

            log.info("Received Kafka Message Key: {}, Value: {}", record.key(), record.value());
            log.info("AI Response Generated: {}", response);

            // 3. Acknowledge message consumption to Kafka
            if (ack != null) {
                ack.acknowledge();
            }

        } catch (Exception e) {
            log.error("Error processing Kafka message from topic {}: {}", record.topic(), e.getMessage(), e);
            throw e;
        }
    }
}
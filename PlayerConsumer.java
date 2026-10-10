//WID(10/10/2026)(Sarthak Mittal(DegamieSign)(PlayerConsumerService)
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;
import tools.jackson.databind.annotation.JsonDeserialize;
//import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
@JsonDeserialize
@EnableKafka
public class PlayerConsumer {
    Logger logger;
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    void handlebootStrapServers(String bootstrapServer){
        try{
            setBootstrapServers(bootstrapServer);
            playerConsumerFactory()+=defaultGroupId;
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        finally {
            logger.info("Player Consumer BootStrap Seveers are handled:"+bootstrapServer);
        }
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }



    @Value("${spring.kafka.consumer.group-id:client-chat-ai-group}")
    private String defaultGroupId;

    @Bean
    public ConsumerFactory<String, PlayerConsumerdto> playerConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, defaultGroupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
//        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);

        // JsonDeserializer configuration
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, PlayerConsumerdto.class.getName());
//        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlayerConsumerdto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PlayerConsumerdto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(playerConsumerFactory());
        // Manual acknowledgment mode enabled
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    public String processDirectPlayerMessage(String msg, PlayerConsumerdto playerConsumerDto) {
        return msg;
    }
}
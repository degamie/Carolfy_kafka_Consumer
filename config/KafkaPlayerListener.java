//WID(24/9/2026)(Sarthak Mittal(DegamieSign)(PLayerListener)#1.1
package com.kafka.Carofly.config;

import com.kafka.Carofly.dto.PlayerEventRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaPlayerListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaPlayerListener.class);

    private final KafkaTemplate<String, PlayerEventRecord> playerKafkaTemplate;

    public KafkaPlayerListener(KafkaTemplate<String, PlayerEventRecord> playerKafkaTemplate) {
        this.playerKafkaTemplate = playerKafkaTemplate;
    }

    /**
     * Consumes incoming player events from the topic.
     * Optionally republishes or forwards processed events using KafkaTemplate.
     */
    @KafkaListener(
            topics = "Player-topic",
            groupId = "player-consumer-groupid"
    )
    public void consumePlayerMessage(
            @Payload String playerMsg,
            @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) String key,
            @Header(value = KafkaHeaders.RECEIVED_PARTITION, required = false) Integer partition,
            @Header(value = KafkaHeaders.OFFSET, required = false) Long offset) {

        log.info("Player Consumer received message [key={}, partition={}, offset={}]: {}",
                key, partition, offset, playerMsg);

        // If forwarding or producing an updated record is needed:
        // PlayerEventRecord record = new PlayerEventRecord(...);
        // playerKafkaTemplate.send("player-processed-topic", key, record);
    }
}
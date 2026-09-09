//WID(9/9/2026)(Sarthak Mittal)(PlayerBroadCastEventListener(IMpl)
package com.kafka.Carofly.config;

import com.kafka.Carofly.service.PlayerBroadCasttRecordEvent;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerBroadCastEventListener {
    void setLogger(Logger logger){this.logger=logger;}
public Logger logger;

    @KafkaListener(
            topics = "broadcast-events",
            groupId = "broadcast-listener-#{T(java.util.UUID).randomUUID().toString()}"
    )
    public void onBroadCastPlayer(PlayerBroadCasttRecordEvent playerbroadCastEvent) {
        switch (playerbroadCastEvent.eventType()) {
            case "CACHE_INVALIDATE" -> handleCacheInvalidate(event.payload());
            case "CONFIG_RELOAD" -> handleConfigReload(event.payload());
            default -> logger.warn("Unhandled broadcast eventType: {}", playerbroadCastEvent.eventType());
        }
    }
}

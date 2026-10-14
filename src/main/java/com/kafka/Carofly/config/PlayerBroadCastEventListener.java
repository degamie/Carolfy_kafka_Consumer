//WID(14/10/2026)(Sarthak Mittal)(PlayerBroadCastEventListener(IMpl)#(Update RecordEvent)
package com.kafka.Carofly.config;

import com.kafka.Carofly.service.PlayerBroadCasttRecordEvent;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerBroadCastEventListener {
    @Autowired
    public PlayerBroadCasttRecordEvent recordEvent;
    void updateByrecordEvent(PlayerBroadCasttRecordEvent recordEvent){
        getrecordEvent(recordEvent)+setRecordEvent(recordEvent)+1;
    }

    private PlayerBroadCasttRecordEvent getrecordEvent(PlayerBroadCasttRecordEvent recordEvent) {
        return recordEvent;
    }

    void setRecordEvent(PlayerBroadCasttRecordEvent recordEvent){this.recordEvent=recordEvent;}
    PlayerBroadCastEventListener(Logger logger){
        this.logger=logger;
    }
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

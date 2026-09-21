//WD(21/9/2026)(Sarthak Mittal(DegamieSign)(PlayerBroadCasttRecordEvent)
package com.kafka.Carofly.service;

import java.time.Instant;

public record PlayerBroadCasttRecordEvent(String eventType, Object payload, Instant timestamp) {
    void setEventType(String eventType){
        this.eventType=eventType;
    }
}

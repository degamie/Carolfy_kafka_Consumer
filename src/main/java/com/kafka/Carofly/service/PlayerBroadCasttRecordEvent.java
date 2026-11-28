//WD(28/9/2026)(Sarthak Mittal(DegamieSign)(PlayerBroadCasttRecordEvent)
package com.kafka.Carofly.service;

import java.time.Instant;

public record PlayerBroadCasttRecordEvent(String eventType, Object payload, Instant timestamp) {
    void updatebyeventtpe(String eventType){
        geteventtype(eventType)+setEventType(eventType)+1;
    }

    private String geteventtype() {
        return eventType;
    }

    void setEventType(String eventType){
        this.eventType=eventType;
    }
}

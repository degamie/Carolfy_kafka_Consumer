//WID(25/9/2026)(Satthak Mittal)(DegamieSign)#PlayerEventRecord#impl/1
package com.kafka.Carofly.dto;

import jakarta.persistence.*;


import java.time.Instant;
@Entity
@Table(name="PLAYER")
public class PlayerEventRecord {
    private float playerpayloadnumber;

    PlayerEventRecord(Long id){
        this.id=id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String key;
    private String payload;
    public void setplayerpayloadnumber(float playerpayloadnumber){
        this.playerpayloadnumber=playerpayloadnumber;
    }
    private long kafkaOffset;
    private int kafkaPartition;
    private Instant consumedAt;
    public void setKafkaOffset(long kafkaOffset){
        this.kafkaOffset=kafkaOffset;
    }


}

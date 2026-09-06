//WID(6/9/2026)(Satthak Mittal)(DegamieSign)
package com.kafka.Carofly.dto;

import jakarta.persistence.*;


import java.time.Instant;
@Entity
@Table(name="PLAYER")
public class PlayerEventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String payload;
    private long kafkaOffset;
    private int kafkaPartition;
    private Instant consumedAt;
    public void setKafkaOffset(long kafkaOffset){
        this.kafkaOffset=kafkaOffset;
    }

}

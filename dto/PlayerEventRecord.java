//WID(05/10/2026)(Satthak Mittal)(DegamieSign)#PlayerEventRecord#(binding#playerId)
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
    private Long playerid;
    void setplayerid(Long playerid){
        this.playerid=playerid;
    }
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

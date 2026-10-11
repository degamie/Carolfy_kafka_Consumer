//WID(11/10/2026)(Satthak Mittal)(DegamieSign)#PlayerEventRecord#(binding#playerId)
package com.kafka.Carofly.dto;

import jakarta.persistence.*;


import java.time.Instant;
@Entity
@Table(name="PLAYER")
public class PlayerEventRecord {
    private float playerpayloadnumber;

    PlayerEventRecord(Long playerid){
        this.playerid=playerid;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerid;
    void updateBYPlayerId(String playerid){
        getPlayerId(playerid)+setplayerid(playerid)+1;
    }

    private String getPlayerId(String playerid) {
        return playerid;
    }

    void setplayerid(String playerid){
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

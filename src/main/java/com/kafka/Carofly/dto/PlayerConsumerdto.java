//WID(15/8/2026(Sarthak Mittal(DegamieSign))(#PlayerCopnusmerdto)#1
package com.kafka.Carofly.dto;

import tools.jackson.databind.ObjectMapper;

import java.time.LocalTime;
import java.util.Date;

public class PlayerConsumerdto {

    void setplayerIdAsFloat(float playerIdAsFloat){
        this.playerIdAsFloat=playerIdAsFloat;
    }
    float getPlayerIdAsfloat(float playerIdAsFloat){
        return playerIdAsFloat;
    }
    public float playerIdAsFloat;
    public Integer playerIdAsInt;
    private String playerId;
    private String playerName;
    private int score;
    private int playerSpeed;
    private Integer playerSpeedAccuracy;
    private Date playerDateCreated;
    private LocalTime playerModifiedDate;

    public PlayerConsumerdto(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ObjectMapper objectMapper;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public PlayerConsumerdto() {
    }

    public PlayerConsumerdto(
            String playerId,
            String playerName,
            int score,
            LocalTime playerModifiedDate,
            Integer playerSpeedAccuracy) {

        this.playerId = playerId;
        this.playerName = playerName;
        this.score = score;
        this.playerModifiedDate = playerModifiedDate;
        this.playerSpeedAccuracy = playerSpeedAccuracy;
    }

    public String getPlayerId(String msg) {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public Integer getPlayerSpeedAccuracy() {
        return playerSpeedAccuracy;
    }

    public void setPlayerSpeedAccuracy(Integer playerSpeedAccuracy) {
        this.playerSpeedAccuracy = playerSpeedAccuracy;
    }

    public Date getPlayerDateCreated() {
        return playerDateCreated;
    }

    public void setPlayerDateCreated(Date playerDateCreated) {
        this.playerDateCreated = playerDateCreated;
    }

    public LocalTime getPlayerModifiedDate() {
        return playerModifiedDate;
    }

    public void setPlayerModifiedDate(LocalTime playerModifiedDate) {
        this.playerModifiedDate = playerModifiedDate;
    }

    @Override
    public String toString() {
        return "PlayerConsumerDto{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                ", playerSpeed=" + playerSpeed +
                ", playerSpeedAccuracy=" + playerSpeedAccuracy +
                ", playerDateCreated=" + playerDateCreated +
                ", playerModifiedDate=" + playerModifiedDate +
                '}';
    }
}
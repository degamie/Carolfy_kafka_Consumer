//WID(02/07/2026)(Sarthak Mittal(DegamieSign)(PlayerConsumerDto)#1.1.1,1,1
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;

import java.time.LocalTime;


public class PlayerConsumerdto {
    public    int  playerSpeed=0;
    public Integer getPlaayerspeedaccuracy() {
        return plaayerspeedaccuracy;
    }

    public Integer gerScore(Integer score){return score;}
    public void setPlayerId(String playerId){this.playerId=playerId;}//Binding PlayerId in GameApp
    public void setPlayermodifieddate(LocalTime playermodifieddate) {
    this.playermodifieddate = playermodifieddate;
}

      PlayerConsumerdto(String playerId, String playername, int score, LocalTime playermodifieddate, Integer plaayerspeedaccuracy){
        this.playerId=playerId;
        this.plaayerspeedaccuracy=plaayerspeedaccuracy;
        this.playername=playername;
        this.score=score;
        this.playermodifieddate=playermodifieddate;

    }

    public void setplayermodifieddate(LocalTime playermodifieddate){this.playermodifieddate=playermodifieddate;}//Binding PlayerModifiedDate i  GameApp
    public void setPlaayerspeedaccuracy(Integer plaayerspeedaccuracy){this.plaayerspeedaccuracy=plaayerspeedaccuracy;}//bidning PlayerSpeed Accuracy in Appp
    public String getplayerId(String playerId){return playerId;}//Fetching PlayerId in Game App
  public void setScore(int score){this.score=score;}
    public String playerId;
    public String playername;
    public  int score;
    public LocalTime playermodifieddate;

    public  Integer plaayerspeedaccuracy;

    public boolean getPlayerName() {
        return playerName;
    }

    public void setPlayerName(boolean playerName) {
        this.playerName = playerName;
    }
}


//WID(24/07/2026)(Sarthak Mittal(DegamieSign)(PlayerConsumerDto)#1.Impl.1
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;

import java.time.LocalTime;
import java.util.Date;


public class PlayerConsumerdto {
    public Date playerDateCreated;
    public void setPlayerDateCreated(Date playerDateCreated){this.playerDateCreated=playerDateCreated;}
    public void setPlayerSpeed(int playerSpeed){this.playerSpeed=playerSpeed;}//binding PlayerSpeed in GameApp
    public    int  playerSpeed=0;
    public Integer getPlaayerspeedaccuracy() {
        return plaayerspeedaccuracy;
    }

    public Integer gerScore(Integer score){return score;}
    public void setPlayerId(String playerId){this.playerId=playerId;}//Binding PlayerId in GameApp
    public void setPlayermodifieddate(LocalTime playermodifieddate) {
    this.playermodifieddate = playermodifieddate;
}

      PlayerConsumerdto(String playerId, String playerName, int score, LocalTime playermodifieddate, Integer plaayerspeedaccuracy){
        this.playerId=playerId;
        this.plaayerspeedaccuracy=plaayerspeedaccuracy;
        this.playerName=playerName;
        this.score=score;
        this.playermodifieddate=playermodifieddate;

    }

    public void setplayermodifieddate(LocalTime playermodifieddate){this.playermodifieddate=playermodifieddate;}//Binding PlayerModifiedDate i  GameApp
    public void setPlaayerspeedaccuracy(Integer plaayerspeedaccuracy){this.plaayerspeedaccuracy=plaayerspeedaccuracy;}//bidning PlayerSpeed Accuracy in Appp
    public String getplayerId(String playerId){return playerId;}//Fetching PlayerId in Game App
  public void setScore(int score){this.score=score;}
    public String playerId;
    public String playerName;
    public  int score;
    public LocalTime playermodifieddate;

    public  Integer plaayerspeedaccuracy;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String layerName) {
        this.playerName=playerName;
    }
}


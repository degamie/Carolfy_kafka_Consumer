//WID(24/06/2026)(Sarthak Mittal(DegamieSign)(PlayerConsumerDto)
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;

import java.time.LocalTime;


public class PlayerConsumerdto {
      PlayerConsumerdto(String playerId, String playername, int score, LocalTime playermodifieddate, Integer plaayerspeedaccuracy){
        this.playerId=playerId;
        this.plaayerspeedaccuracy=plaayerspeedaccuracy;
        this.playername=playername;
        this.score=score;
        this.playermodifieddate=playermodifieddate;

    }
    public String getplayerId(String playerId){return playerId;}//Fetching PlayerId in Game App
  
    public String playerId;
    public String playername;
    public  int score;
    public LocalTime playermodifieddate;
    public  Integer plaayerspeedaccuracy;
}


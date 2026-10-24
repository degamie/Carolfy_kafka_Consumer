//WID(24/10/2026)(Sarthak Mittal)(DegamieSign)(Saving#playerscore)
package com.kafka.Carofly.repository;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<String, PlayerConsumerdto>{
    List<String>savebyplayerscore(int playerscore);
    List<String>findByplayerspeed(int playerspeed);
    List<String>findByplayerSpeedAccuracy(int playerspeedaccuracy);
    List<String>findByplayerCreatedDate(Date playercreatedDate);
    public List<String>findByplayer score(int playerscore);
    public List<String>savebyplayerid(String playerId);
    public List<String>findbyplayername(String playername);
}

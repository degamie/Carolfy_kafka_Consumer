//WID(17/10/2026)(Sarthak Mittal)(DegamieSign)(fetching playerName)
package com.kafka.Carofly.repository;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<String, PlayerConsumerdto>{
    public List<String>savebyplayerid(String playerId);
    public List<String>findbyplayername(String playername);
}

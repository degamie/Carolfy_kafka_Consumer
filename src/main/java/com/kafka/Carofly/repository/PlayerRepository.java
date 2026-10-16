package com.kafka.Carofly.repository;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<String, PlayerConsumerdto>{
    public List<String>savebyplayerid(String playerId);
}

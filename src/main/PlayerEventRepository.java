//WID(22.9.2026)(Sarthak Mittal(DegamieSign)(PlayerEventRepsoitory)#1
package com.kafka.Carofly.repository;

import com.anthropic.core.Page;
import com.kafka.Carofly.dto.PlayerEventRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
@Repository
public interface PlayerEventRepository extends JpaRepository<PlayerEventRecord,String> {
    Page<String>findAllByPlayerConsumerId(String playerid,Pageable pageable)l
    Page<String> findAllByOrderConsumedatDesc(Pageable pageable);
}

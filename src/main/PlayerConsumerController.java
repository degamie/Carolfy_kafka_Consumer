//WID(5/9/2026)(Sarthak Mittal(DegamieSign(PlayerConsumerCntrller(Param_Constr))#1
package com.kafka.Carofly.Controller;

import com.anthropic.core.Page;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import com.kafka.Carofly.dto.PlayerEventRecord;
import com.kafka.Carofly.repository.PlayerEventRepository;
import com.kafka.Carofly.service.PlayerConsumer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@EnableCaching
@Controller
@RestController("/player-consumer")

public class PlayerConsumerController {
    @Autowired
    public PlayerConsumer playerConsumer;
    @Autowired
    PlayerEventRepository playerEventRepository;
    @GetMapping("/playerevents")
            public Page<PlayerEventRecord>getplayereents(@RequestParam (defaultValue = "5")int page,@RequestParam (defaultValue = "10")int size,@RequestParam (defaultValue = "15")int sort){
        String[] sortParams = sort.split(",");
        Sort.Direction direction = sortParams.length > 1 && sortParams[1].equalsIgnoreCase("asc")
                ? Sort.Direction.ASC : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortParams[0]));
        return PlayerEventRepository.findAll(pageable);
    }
    PlayerConsumerController(PlayerConsumer playerConsumer){
        this.playerConsumer=playerConsumer;
    }
    @GetMapping("/playerid")
    public String consumeplayerid(@RequestAttribute  String playerconsumerid){
        return playerConsumer.consumeplayerid(playerconsumerid);
    }
//@As
    @GetMapping("/message")
    public List<PlayerConsumerdto> consume(@RequestBody PlayerConsumerdto playerConsumerdto, @RequestBody ChatClient chatClient, @RequestBody Acknowledgment ack, @RequestAttribute  String msg) throws Exception {//consume method declare
        return playerConsumer.consume(msg,playerConsumerdto,chatClient,ack);
    }

}

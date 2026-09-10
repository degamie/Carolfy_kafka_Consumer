//WID(9/9/2026)(Sarthak Mittal(DegamieSign(PlayerConsumerCntrller(Param_Constr))#1
package com.kafka.Carofly.Controller;

//import com.kafka.Carofly.dto.PlayerConsumerdto;
//import com.kafka.Carofly.service.PlayerConsumer;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import com.kafka.Carofly.service.PlayerConsumer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@EnableCaching
@Controller
@RestController("/player-consumer")

public class PlayerConsumerController {
    @Autowired
    public PlayerConsumerService playerConsumer;
    @Cacheable("/player-message")
    @GetMapping("/message")
    public List<PlayerConsumerdto> consume(@RequestBody PlayerConsumerdto playerConsumerdto, @RequestBody ChatClient chatClient, @RequestBody Acknowledgment ack, @RequestAttribute  String msg) throws Exception {//consume method declare
        return playerConsumer.consume(msg,playerConsumerdto,chatClient,ack);
    }

    PlayerConsumerController(PlayerConsumer playerConsumer){
        this.playerConsumer=playerConsumer;
    }
//@As

}

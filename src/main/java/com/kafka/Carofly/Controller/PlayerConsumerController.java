//WID(16/10/2026)(Sarthak Mittal(DegamieSign(PlayerConsumerCntrller(Param_Constr))#1
package com.kafka.Carofly.Controller;

//import com.kafka.Carofly.dto.PlayerConsumerdto;
//import com.kafka.Carofly.service.PlayerConsumer;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import com.kafka.Carofly.service.PlayerBroadCastService;
import com.kafka.Carofly.service.PlayerConsumer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
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
    public PlayerConsumer playerConsumer;
    @Autowired
    public PlayerBroadCastService playerBroadCastService;
    @PostMapping("/playerid")
    public void sendplayerid(String playerId){
        playerConsumer.sendplayerid(playerId);
    }
    @Cacheable("/player-message")
    @GetMapping("/message")
    public List<PlayerConsumerdto> consume(@RequestBody PlayerConsumerdto playerConsumerdto, @RequestBody ChatClient chatClient, @RequestBody Acknowledgment ack, @RequestAttribute  String msg) throws Exception {//consume method declare
        return playerConsumer.consume(msg,playerConsumerdto,chatClient,ack);
    }
    private PlayerConsumerController getplayerConsumerController(PlayerConsumerController playerConsumerController) {
        return playerConsumerController;
    }
    void updatePlayerConsumerController(PlayerConsumerController playerConsumerController)throws Exception{
        if(!playerConsumerController.equals(null))getplayerConsumerController(playerConsumerController);
        else getplayerConsumerController(null);
    }




    PlayerConsumerController(PlayerConsumer playerConsumer){
        this.playerConsumer=playerConsumer;
    }
//@As

}

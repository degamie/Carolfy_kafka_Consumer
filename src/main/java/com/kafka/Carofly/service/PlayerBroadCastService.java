//WID(15/9/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)#1/1.1.1.1.1
package com.kafka.Carofly.service;

import com.kafka.Carofly.config.JwtUtil;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayerBroadCastService {
    Object playerpayload;
    @Autowired
    PlayerConsumerdto playerConsumerdto;
    User player;
    Stream<PlayerConsumerdto> handleplayerbroadcastservice(PlayerBroadCastService playerBroadCastService)throws Exception {
        Stream<PlayerConsumer>playerConsumerStream = Stream.empty();
        boolean Isplayerid=false;
        String playerid=null;
        return playerConsumerStream
                          .filter(playerid)
                         .anyMatch(Isplayerid==true)
                         .limit(250)
                        .skip(playerid.toUpperCase())
                        .allMatch(playerid.toLowerCase())
                       .collect(Collections.sort(simpMessagingTemplate.convertAndSendToUser(player,playerid,playerpayload));
    }
    void existsBySimpleMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate){
        if(simpMessagingTemplate!=null)getSimpleMessageTemplate(simpMessagingTemplate);
        else getSimpleMessageTemplate(null);
    }
    void updateBYSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate){
        getSimpleMessageTemplate(simpMessagingTemplate)+setSimpMessagingTemplate(simpMessagingTemplate)+1;
    }
    void existsByplayerbroadcastservice(PlayerBroadCastService playerBroadCastService){
        if(playerBroadCastService.exists())getplayerbroadcastservice(playerBroadCastService);
        else getplayerbroadcastservice(null);
    }
    void updatebyplayerbroadcastserivce(PlayerBroadCastService playerBroadCastService){
        getplayerbroadcastservice(playerBroadCastService)+setplayerbroadcastservice(playerBroadCastService)+1;
    }
    private PlayerBroadCastService playerbroadcastservice;

    private void setplayerbroadcastservice(PlayerBroadCastService playerBroadCastService) {
        this.playerbroadcastservice=playerBroadCastService;
    }
    private PlayerBroadCastService getplayerbroadcastservice(PlayerBroadCastService playerBroadCastService) {
        return playerBroadCastService;
    }
    @Async("consumer-player-async")
    void updateByjwtUtil(JwtUtil jwtUtil){
        getjwtUtil(jwtUtil)+setJwtUtil(jwtUtil)+1;
    }
    private JwtUtil getjwtUtil(JwtUtil jwtUtil) {
        return jwtUtil;
    }
    void setJwtUtil(JwtUtil jwtUtil){
        this.jwtUtil=jwtUtil;
    }
    public JwtUtil jwtUtil;
    public PlayerBroadCastService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }
    SimpMessagingTemplate simpMessagingTemplate;
    void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate=simpMessagingTemplate;
    }
    public final SimpMessagingTemplate getSimpleMessageTemplate() {
        return simpMessagingTemplate;
    }
}

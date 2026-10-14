//WID(14/10/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)(handling Playermoves)
package com.kafka.Carofly.service;

import com.kafka.Carofly.config.JwtUtil;
import com.kafka.Carofly.dto.PlayerConsumerdto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Transactional(readOnly = true)
@Service
public class PlayerBroadCastService {
    Logger logger;
    void setplayermoves(int moves,PlayerConsumerdto playerConsumerdto){
        this.playerConsumerdto=playerConsumerdto;
    }
    void handleplayermoves(int moves,int cnt,PlayerConsumerdto playerConsumerdto) throws RuntimeException{
        try{
            setplayermoves(moves,playerConsumerdto)+=incrementPlayermoves(moves,cnt,playerConsumerdto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            logger.info("Player Moves are being handled:"+moves);
        }
    }
    void incrementPlayermoves(int moves,int cnt,PlayerConsumerdto playerConsumerdto){
        if(playerConsumerdto.length()!=0){
            cnt+=moves;
        }else cnt=0;
        return cnt;
    }
    void updateByplayer(PlayerConsumerdto playerConsumerdto){
        getplayer(playerConsumerdto)+setplayer(playerConsumerdto)+1;
    }
    private PlayerConsumerdto getplayer(PlayerConsumerdto playerConsumerdto) {
        return playerConsumerdto;
    }




    void setplayer(PlayerConsumerdto player){
        this.player=player;
    }
    Object playerpayload;

    void updateByPlayerPayload(Object playerpayload){
        getPlayerpayload(playerpayload)+setPlayerpayload(playerpayload)+1;
    }



    Object getPlayerpayload(Object playerpayload){
        return playerpayload;
    }

    void setPlayerpayload(Object playerpayload){
        this.playerpayload=playerpayload;
    }

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

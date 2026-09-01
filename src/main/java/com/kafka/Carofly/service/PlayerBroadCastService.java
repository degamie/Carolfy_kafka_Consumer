//WID(01/9/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)#1/1.1
package com.kafka.Carofly.service;

import com.kafka.Carofly.config.JwtUtil;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class PlayerBroadCastService {
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

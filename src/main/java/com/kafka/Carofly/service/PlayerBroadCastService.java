//WID(24/8/2026)(Sarthak Mittal(Degamiesign)(PlayerBroadCastService)
package com.kafka.Carofly.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
@Service
public class PlayerBroadCastService {
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

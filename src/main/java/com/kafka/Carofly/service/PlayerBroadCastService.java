//WID(14/8/2026)(Sarthak Mittal(Degamiesign)
package com.kafka.Carofly.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
@Service
public class PlayerBroadCastService {
    public PlayerBroadCastService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    SimpMessagingTemplate simpMessagingTemplate;
    public final SimpMessagingTemplate getSimpleMessageTemplate() {
        return simpMessagingTemplate;
    }
}

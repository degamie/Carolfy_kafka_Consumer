package com.kafka.Carofly.service;

import java.time.Instant;

public record PlayerBroadCasttRecordEvent(String eventType, Object payload, Instant timestamp) {}

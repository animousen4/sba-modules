package com.animousen4.game.engine.core.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TimestampService {
    Timestamp getCurrentTime() {
        return Timestamp.valueOf(LocalDateTime.now());
    }
}

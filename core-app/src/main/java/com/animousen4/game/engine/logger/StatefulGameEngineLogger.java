package com.animousen4.game.engine.logger;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StatefulGameEngineLogger {

    public void logStartup() {
        log.info("Engine is started");
    }

    public void logNewFenPosition(String fen) {
        log.info("Received a new fen: %s".formatted(fen));

    }

    public void logStatus(String status) {
        log.info("Engine status: %s".formatted(status));
    }
}

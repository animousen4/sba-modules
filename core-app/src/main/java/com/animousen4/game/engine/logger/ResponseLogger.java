package com.animousen4.game.engine.logger;

import com.animousen4.game.engine.dto.h1.CoreResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class ResponseLogger extends AbstractJsonLogger {
    public void logResponse(CoreResponse coreResponse) {
        try {
            log.info("\n<---\nRESPONSE:\n".concat(logObject(coreResponse)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}

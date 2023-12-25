package com.animousen4.game.engine.logger;

import com.animousen4.game.engine.dto.CoreRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RequestLogger extends AbstractLogger{
    public void logRequest(CoreRequest coreRequest) {
        try {
            log.info("\n--->\nREQUEST:\n".concat(logObject(coreRequest)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}

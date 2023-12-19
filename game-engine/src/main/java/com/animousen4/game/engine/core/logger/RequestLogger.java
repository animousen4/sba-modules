package com.animousen4.game.engine.core.logger;

import com.animousen4.game.engine.dto.CoreRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestLogger extends AbstractLogger{
    public void logRequest(CoreRequest coreRequest) {
        try {
            log.info(logObject(coreRequest));
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}

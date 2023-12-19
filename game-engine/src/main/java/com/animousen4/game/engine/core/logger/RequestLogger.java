package com.animousen4.game.engine.core.logger;

import com.animousen4.game.engine.dto.CoreRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestLogger {
    public void logRequest(CoreRequest coreRequest) {
        log.info(coreRequest.toString());
    }
}

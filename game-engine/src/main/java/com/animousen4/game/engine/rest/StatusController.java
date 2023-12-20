package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.core.logger.RequestLogger;
import com.animousen4.game.engine.core.services.StatusService;
import com.animousen4.game.engine.dto.v1.GetFullStatusInfoRequestV1;
import com.animousen4.game.engine.dto.v1.GetFullStatusInfoResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/api/status",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public class StatusController {

    @Autowired
    StatusService statusService;

    @Autowired
    RequestLogger requestLogger;

    @PostMapping(
            path="/getStatusInfo"
    )
    public GetFullStatusInfoResponseV1 getFullStatusInfo(
            @RequestBody GetFullStatusInfoRequestV1 request
    ) {
        requestLogger.logRequest(request);
        return processRequest(request);
    }

    public GetFullStatusInfoResponseV1 processRequest(GetFullStatusInfoRequestV1 requestV1) {
        var res = statusService.getFullStatusInfo(requestV1);
        if (!res.hasErrors()) {
            return GetFullStatusInfoResponseV1.builder()
                    .statusInfo(res.getStatusInfo())
                    .build();
        } else {
            return GetFullStatusInfoResponseV1.builder().errors(
                    res.getValidationErrors()
            ).build();
        }

    }
}

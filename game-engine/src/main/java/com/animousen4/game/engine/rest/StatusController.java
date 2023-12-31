package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.logger.RequestLogger;
import com.animousen4.game.engine.core.services.StatusService;
import com.animousen4.game.engine.dto.v1.getFullStatusInfo.GetFullStatusInfoRequestV1;
import com.animousen4.game.engine.dto.v1.getFullStatusInfo.GetFullStatusInfoResponseV1;
import com.animousen4.game.engine.logger.ResponseLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/api/v1/status",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public class StatusController {

    @Autowired
    StatusService statusService;

    @Autowired
    RequestLogger requestLogger;

    @Autowired
    ResponseLogger responseLogger;

    @PostMapping(
            path="/getStatusInfo"
    )
    public GetFullStatusInfoResponseV1 getFullStatusInfo(
            @RequestBody GetFullStatusInfoRequestV1 request
    ) {
        requestLogger.logRequest(request);
        var response = processRequest(request);
        responseLogger.logResponse(response);

        return response;
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

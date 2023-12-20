package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.core.services.StatusService;
import com.animousen4.game.engine.dto.v1.GetFullStatusInfoRequestV1;
import com.animousen4.game.engine.dto.v1.GetFullStatusInfoResponseV1;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.SolvePositionResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    @PostMapping(
            path="/getStatusInfo"
    )
    public GetFullStatusInfoResponseV1 getFullStatusInfo(
            GetFullStatusInfoRequestV1 request
    ) {
        return processRequest(request);
    }

    public GetFullStatusInfoResponseV1 processRequest(GetFullStatusInfoRequestV1 requestV1) {
        return GetFullStatusInfoResponseV1.builder()

                .build();
    }
}

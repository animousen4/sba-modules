package com.animousen4.game.engine.rest.v1;

import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;
import com.animousen4.game.engine.core.services.PositionSolverService;
import com.animousen4.game.engine.dto.h1.v1.solvePosition.SolvePositionConverterV1;
import com.animousen4.game.engine.dto.h1.v1.solvePosition.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.h1.v1.solvePosition.SolvePositionResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/api/v1/chess-engine",
        consumes = "application/json",
        produces = "application/json"
)
public class EngineController {

    @Autowired
    SolvePositionConverterV1 solvePositionConverterV1;

    @Autowired
    private PositionSolverService gameEngineService;

    @PostMapping(
            path="/solvePosition"
    )
    public SolvePositionResponseV1 solvePosition(
            @RequestBody SolvePositionRequestV1 request
            ) {
        return buildSolvePositionResponse(request);
    }

    private SolvePositionResponseV1 buildSolvePositionResponse(SolvePositionRequestV1 requestV1) {
        SolvePositionCommand cmd = solvePositionConverterV1.buildCommand(requestV1);
        SolvePositionResult res = gameEngineService.solvePosition(cmd);
        return solvePositionConverterV1.buildResponse(res);

    }
}

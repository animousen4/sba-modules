package com.animousen4.game.engine.rest;

import com.animousen4.game.engine.core.services.GameEngineService;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.SolvePositionResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chess-engine")
public class GameEngineController {

    @Autowired
    private GameEngineService gameEngineService;

    @PostMapping(
            path="/solvePosition",
            consumes = "application/json",
            produces = "application/json"
    )
    public SolvePositionResponseV1 solvePosition(
            @RequestBody SolvePositionRequestV1 request
            ) {
        return gameEngineService.solvePosition(request);
    }
}

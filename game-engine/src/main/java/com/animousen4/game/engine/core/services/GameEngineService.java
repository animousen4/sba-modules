package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.SolvePositionResponseV1;

public interface GameEngineService {
    SolvePositionResponseV1 solvePosition(SolvePositionRequestV1 request);
}

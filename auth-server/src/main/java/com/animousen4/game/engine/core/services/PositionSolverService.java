package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.dto.v1.SomeRequestV1;
import com.animousen4.game.engine.dto.v1.SomeResponseV1;

public interface PositionSolverService {
    SomeResponseV1 solvePosition(SomeRequestV1 request);
}

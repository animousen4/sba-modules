package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionResponseV1;

public interface PositionSolverService {
    SolvePositionResult solvePosition(SolvePositionCommand solvePositionCommand);
}

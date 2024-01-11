package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;

public interface PositionSolverService {
    SolvePositionResult solvePosition(SolvePositionCommand solvePositionCommand);
}

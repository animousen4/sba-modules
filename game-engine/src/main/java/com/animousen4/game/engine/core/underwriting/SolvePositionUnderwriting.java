package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.underwriting.res.SolvePositionResult;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionRequestV1;

public interface SolvePositionUnderwriting {

    SolvePositionResult calculateBestMove(SolvePositionRequestV1 requestV1);
}

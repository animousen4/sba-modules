package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.services.GameEngineService;
import com.animousen4.game.engine.core.underwriting.res.SolvePositionResult;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SolvePositionUnderwritingImpl implements SolvePositionUnderwriting{

    @Autowired
    GameEngineService gameEngineService;

    @Override
    public SolvePositionResult calculateBestMove(SolvePositionRequestV1 requestV1) {
        var answer = gameEngineService.getBestSolution(requestV1.getFenPosition(), 14000);
        return new SolvePositionResult(answer.getLan(), Arrays.toString(answer.getContinuation()));
    }
}

package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.underwriting.res.SolvePositionResult;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import org.springframework.stereotype.Component;

@Component
class SolvePositionUnderwritingImpl implements SolvePositionUnderwriting{

    @Override
    public SolvePositionResult calculateBestMove(SolvePositionRequestV1 requestV1) {
        //
        return new SolvePositionResult("e2e4", "e7e6");
    }
}

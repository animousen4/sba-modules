package com.animousen4.game.engine.dto.h1.v1.solvePosition;

import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;
import com.animousen4.game.engine.dto.h1.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class SolvePositionConverterV1 implements
        AbstractConverter<
                SolvePositionRequestV1,
                SolvePositionCommand,
                SolvePositionResponseV1,
                SolvePositionResult
                > {
    @Override
    public SolvePositionCommand buildCommand(SolvePositionRequestV1 request) {
        return SolvePositionCommand.builder()
                .fenPosition(request.getFenPosition())
                .duration(request.getDuration())
                .depth(request.getDepth())
                .build();
    }

    @Override
    public SolvePositionResponseV1 buildResponse(SolvePositionResult result) {
        return SolvePositionResponseV1.builder()
                .bestMove(result.getBestMove())
                .build();
    }
}

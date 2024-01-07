package com.animousen4.game.engine.dto.v1.solvePosition;

import com.animousen4.game.engine.core.api.command.CreateOrUpdateUserCommand;
import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.result.CreateOrUpdateUserResult;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;
import com.animousen4.game.engine.dto.AbstractConverter;
import com.animousen4.game.engine.dto.v1.createOrUpdateUser.CreateOrUpdateUserRequestV1;
import com.animousen4.game.engine.dto.v1.createOrUpdateUser.CreateOrUpdateUserResponseV1;
import org.springframework.stereotype.Component;

@Component
public class SolvePositionConverterV1 extends
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

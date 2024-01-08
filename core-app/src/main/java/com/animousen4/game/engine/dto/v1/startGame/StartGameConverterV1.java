package com.animousen4.game.engine.dto.v1.startGame;

import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.dto.AbstractConverter;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionRequestV1;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionResponseV1;
import org.springframework.stereotype.Component;

@Component
public class StartGameConverterV1 extends
        AbstractConverter<
                StartGameRequestV1,
                StartGameCommand,
                StartGameResponseV1,
                StartGameResult
                > {

    @Override
    public StartGameCommand buildCommand(StartGameRequestV1 request) {
        return StartGameCommand.builder()
                .name(request.getName())
                .build();
    }

    @Override
    public StartGameResponseV1 buildResponse(StartGameResult result) {
        return StartGameResponseV1.builder()
                .status(result.getStatus())
                .build();
    }
}

package com.animousen4.game.engine.dto.h1.v1.makeMove;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;
import com.animousen4.game.engine.dto.h1.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class MakeMoveConverterV1 implements AbstractConverter<MakeMoveRequestV1, MakeMoveCommand, MakeMoveResponseV1, MakeMoveResult> {
    @Override
    public MakeMoveCommand buildCommand(MakeMoveRequestV1 request) {
        return MakeMoveCommand.builder()
                .moveFrom(request.getMoveFrom())
                .moveTo(request.getMoveTo())
                .gameId(request.getGameId())
                .build();
    }

    @Override
    public MakeMoveResponseV1 buildResponse(MakeMoveResult result) {
        return MakeMoveResponseV1.builder()
                .errors(result.getValidationErrors())
                .build();
    }
}

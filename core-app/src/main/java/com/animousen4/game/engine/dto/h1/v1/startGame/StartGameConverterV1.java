package com.animousen4.game.engine.dto.h1.v1.startGame;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.mapper.game.GameMapper;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.dto.h1.AbstractConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartGameConverterV1 implements
        AbstractConverter<
                StartGameRequestV1,
                StartGameCommand,
                StartGameResponseV1,
                StartGameResult
                > {


    final GameMapper gameMapper;
    @Override
    public StartGameCommand buildCommand(StartGameRequestV1 request) {
        return StartGameCommand.builder()
                .gameInfo(request.getGameInfo())
                .build();
    }

    @Override
    public StartGameResponseV1 buildResponse(StartGameResult result) {
        return StartGameResponseV1.builder()
                .status(result.getStatus())
                .game(gameMapper.map(result.getGameStoredModel()))
                .errors(result.getValidationErrors())
                .build();
    }
}

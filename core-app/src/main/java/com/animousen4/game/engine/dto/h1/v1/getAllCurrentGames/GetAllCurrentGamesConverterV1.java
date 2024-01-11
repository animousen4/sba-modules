package com.animousen4.game.engine.dto.h1.v1.getAllCurrentGames;

import com.animousen4.game.engine.core.api.mapper.GameMapper;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.dto.h1.AbstractResultConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllCurrentGamesConverterV1 implements AbstractResultConverter
        <GetAllCurrentGamesResponseV1, AllCurrentGamesResult> {

    private final GameMapper gameMapper;
    @Override
    public GetAllCurrentGamesResponseV1 buildResponse(AllCurrentGamesResult result) {
        return GetAllCurrentGamesResponseV1.builder()
                .games(
                        result.getGames().stream()
                                .map(gameMapper::map)
                                .collect(Collectors.toList()
                                )
                )
                .errors(result.getValidationErrors())
                .build();
    }
}

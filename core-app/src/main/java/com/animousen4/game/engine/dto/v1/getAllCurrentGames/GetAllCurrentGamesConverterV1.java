package com.animousen4.game.engine.dto.v1.getAllCurrentGames;

import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.dto.AbstractConverter;
import com.animousen4.game.engine.dto.AbstractResultConverter;
import org.springframework.stereotype.Component;

@Component
public class GetAllCurrentGamesConverterV1 implements AbstractResultConverter
        <GetAllCurrentGamesResponseV1, AllCurrentGamesResult> {

    @Override
    public GetAllCurrentGamesResponseV1 buildResponse(AllCurrentGamesResult result) {
        return GetAllCurrentGamesResponseV1.builder()
                .games(result.getGames())
                .errors(result.getValidationErrors())
                .build();
    }
}

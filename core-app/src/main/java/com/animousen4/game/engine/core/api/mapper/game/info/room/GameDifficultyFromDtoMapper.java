package com.animousen4.game.engine.core.api.mapper.game.info.room;

import com.animousen4.game.engine.core.api.mapper.NullableMapper;
import com.animousen4.game.engine.dto.h1.entities.room.GameDifficultyDto;
import org.springframework.stereotype.Component;

@Component
public class GameDifficultyFromDtoMapper extends NullableMapper<GameDifficultyDto, Double> {
    @Override
    protected Double safeMap(GameDifficultyDto model) {
        return switch (model) {
            case EASY -> 0.33;
            case MEDIUM -> 0.66;
            case HARD -> 1.0;
            case UNDEFINED -> null;
        };
    }
}

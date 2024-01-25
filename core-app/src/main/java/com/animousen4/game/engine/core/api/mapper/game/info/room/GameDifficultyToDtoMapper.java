package com.animousen4.game.engine.core.api.mapper.game.info.room;

import com.animousen4.game.engine.core.api.exception.GameDifficultyException;
import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.dto.h1.entities.room.GameDifficultyDto;
import org.springframework.stereotype.Component;

@Component
public class GameDifficultyToDtoMapper extends Mapper<Double, GameDifficultyDto> {
    @Override
    public GameDifficultyDto map(Double value)  {
        if (value >= 0 && value <= 0.33)
            return GameDifficultyDto.EASY;
        if (value > 0.33 && value <= 0.66)
            return GameDifficultyDto.MEDIUM;
        if (value > 0.66 && value <= 1.0)
            return GameDifficultyDto.HARD;

        return GameDifficultyDto.UNDEFINED;

    }
}

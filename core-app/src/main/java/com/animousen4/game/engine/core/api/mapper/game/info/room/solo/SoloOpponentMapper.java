package com.animousen4.game.engine.core.api.mapper.game.info.room.solo;

import com.animousen4.game.engine.core.api.exception.GameDifficultyException;
import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.mapper.NullableMapper;
import com.animousen4.game.engine.core.api.model.game.info.SoloOpponentModel;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloOpponentDto;
import org.springframework.stereotype.Component;

@Component
public class SoloOpponentMapper extends NullableMapper<SoloOpponentDto, SoloOpponentModel> {
    @Override
    protected SoloOpponentModel safeMap(SoloOpponentDto model) {
        return switch (model) {
            case ONLINE -> SoloOpponentModel.ONLINE;
            case COMPUTER -> SoloOpponentModel.COMPUTER;
        };
    }
}

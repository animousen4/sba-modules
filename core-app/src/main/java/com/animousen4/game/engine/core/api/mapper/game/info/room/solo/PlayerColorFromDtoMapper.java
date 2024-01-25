package com.animousen4.game.engine.core.api.mapper.game.info.room.solo;

import com.animousen4.game.engine.core.api.mapper.NullableMapper;
import com.animousen4.game.engine.core.api.model.game.PlayerColorModel;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloPlayerColorDto;
import org.springframework.stereotype.Component;

@Component
public class PlayerColorFromDtoMapper extends NullableMapper<SoloPlayerColorDto, PlayerColorModel> {

    @Override
    protected PlayerColorModel safeMap(SoloPlayerColorDto model) {
        return switch (model) {
            case WHITE -> PlayerColorModel.WHITE;
            case BLACK -> PlayerColorModel.BLACK;
            case RANDOM -> PlayerColorModel.RANDOM;
        };
    }
}

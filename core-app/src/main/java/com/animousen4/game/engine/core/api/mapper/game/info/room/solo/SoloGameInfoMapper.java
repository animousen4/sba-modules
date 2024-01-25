package com.animousen4.game.engine.core.api.mapper.game.info.room.solo;

import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.mapper.NullableMapper;
import com.animousen4.game.engine.core.api.mapper.game.info.room.GameDifficultyFromDtoMapper;
import com.animousen4.game.engine.core.api.model.game.info.SoloGameInfoModel;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloGameInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SoloGameInfoMapper extends NullableMapper<SoloGameInfoDto, SoloGameInfoModel> {

    private final GameDifficultyFromDtoMapper gameDifficultyMapper;

    private final SoloOpponentMapper soloOpponentMapper;

    private final PlayerColorFromDtoMapper playerColorMapper;

    @Override
    public SoloGameInfoModel safeMap(SoloGameInfoDto model) {
        return SoloGameInfoModel.builder()
                .gameDifficulty(gameDifficultyMapper.map(model.getGameDifficulty()))
                .opponentModel(soloOpponentMapper.map(model.getOpponent()))
                .playerColorModel(playerColorMapper.map(model.getColor()))
                .build();
    }
}

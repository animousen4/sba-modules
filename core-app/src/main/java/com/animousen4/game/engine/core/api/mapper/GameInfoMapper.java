package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.api.model.game.GameInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameInfoMapper implements ModelDtoMapper<GameInfoModel, GameInfoDTO>{

    final SideInfoMapper sideInfoMapper;
    @Override
    public GameInfoDTO map(GameInfoModel gameInfoModel) {
        return GameInfoDTO.builder()
                .whiteSide(sideInfoMapper.map(gameInfoModel.getWhiteSide()))
                .blackSide(sideInfoMapper.map(gameInfoModel.getBlackSide()))
                .build();
    }
}

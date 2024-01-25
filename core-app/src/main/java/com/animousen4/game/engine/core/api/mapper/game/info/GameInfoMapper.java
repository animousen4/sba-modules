package com.animousen4.game.engine.core.api.mapper.game.info;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.model.game.info.GameInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameInfoMapper extends Mapper<GameInfoModel, GameInfoDTO> {

    final SideInfoMapper sideInfoMapper;
    @Override
    public GameInfoDTO map(GameInfoModel gameInfoModel) {
        return GameInfoDTO.builder()
                .whiteSide(sideInfoMapper.map(gameInfoModel.getWhiteSide()))
                .blackSide(sideInfoMapper.map(gameInfoModel.getBlackSide()))
                .build();
    }
}

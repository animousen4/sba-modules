package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.core.api.dto.game.SideInfoDTO;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.model.game.SideInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SideInfoMapper implements ModelDtoMapper<SideInfoModel, SideInfoDTO>{
    final ChessBoardMapper chessBoardMapper;

    @Override
    public SideInfoDTO map(SideInfoModel sideInfoModel) {
        return SideInfoDTO.builder()
                .clock(sideInfoModel.getClock())
                .sideId(sideInfoModel.getSideId())
                .build();
    }
}

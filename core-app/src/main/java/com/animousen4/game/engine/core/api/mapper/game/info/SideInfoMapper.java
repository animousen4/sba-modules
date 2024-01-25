package com.animousen4.game.engine.core.api.mapper.game.info;

import com.animousen4.game.engine.core.api.dto.game.SideInfoDTO;
import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.mapper.game.ChessBoardStoredMapper;
import com.animousen4.game.engine.core.api.model.game.info.SideInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SideInfoMapper extends Mapper<SideInfoModel, SideInfoDTO> {
    final ChessBoardStoredMapper chessBoardStoredMapper;

    @Override
    public SideInfoDTO map(SideInfoModel sideInfoModel) {
        return SideInfoDTO.builder()
                .clock(sideInfoModel.getClock())
                .sideId(sideInfoModel.getSideId())
                .build();
    }
}

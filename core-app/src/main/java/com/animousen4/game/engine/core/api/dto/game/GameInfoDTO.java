package com.animousen4.game.engine.core.api.dto.game;

import com.animousen4.game.engine.core.api.model.game.SideInfoModel;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class GameInfoDTO {
    SideInfoModel whiteSide;
    SideInfoModel blackSide;
}

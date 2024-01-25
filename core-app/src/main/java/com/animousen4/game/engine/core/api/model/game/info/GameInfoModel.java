package com.animousen4.game.engine.core.api.model.game.info;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameInfoModel {
    SideInfoModel whiteSide;
    SideInfoModel blackSide;
}

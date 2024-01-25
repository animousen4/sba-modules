package com.animousen4.game.engine.core.api.dto.game;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class GameInfoDTO {
    SideInfoDTO whiteSide;
    SideInfoDTO blackSide;
}

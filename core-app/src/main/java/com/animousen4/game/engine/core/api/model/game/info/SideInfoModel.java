package com.animousen4.game.engine.core.api.model.game.info;

import com.animousen4.game.engine.core.api.model.game.board.ChessClock;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SideInfoModel {
    Long sideId;
    ChessClock clock;
}

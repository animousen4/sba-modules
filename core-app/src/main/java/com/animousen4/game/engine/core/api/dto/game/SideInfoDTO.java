package com.animousen4.game.engine.core.api.dto.game;

import com.animousen4.game.engine.core.api.model.game.board.ChessClock;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SideInfoDTO {
    Long sideId;
    ChessClock clock;
}

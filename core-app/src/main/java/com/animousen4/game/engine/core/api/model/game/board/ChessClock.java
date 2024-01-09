package com.animousen4.game.engine.core.api.model.game.board;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ChessClock {
    Long bonusTime;
    Long leftTime;
}

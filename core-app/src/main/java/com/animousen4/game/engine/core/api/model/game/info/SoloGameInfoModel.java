package com.animousen4.game.engine.core.api.model.game.info;

import com.animousen4.game.engine.core.api.model.game.PlayerColorModel;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SoloGameInfoModel {
    PlayerColorModel playerColorModel;

    SoloOpponentModel opponentModel;

    Double gameDifficulty;

}

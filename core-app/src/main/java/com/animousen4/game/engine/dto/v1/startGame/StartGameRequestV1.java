package com.animousen4.game.engine.dto.v1.startGame;

import com.animousen4.game.engine.core.api.model.game.GameInfo;
import com.animousen4.game.engine.dto.CoreRequest;
import lombok.Getter;

@Getter
public class StartGameRequestV1 extends CoreRequest {
    private GameInfo gameInfo;
}

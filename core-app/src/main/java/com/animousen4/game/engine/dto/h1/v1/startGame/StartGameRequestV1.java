package com.animousen4.game.engine.dto.h1.v1.startGame;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.dto.h1.CoreRequest;
import lombok.Getter;

@Getter
public class StartGameRequestV1 extends CoreRequest {
    private GameInfoDTO gameInfo;
}

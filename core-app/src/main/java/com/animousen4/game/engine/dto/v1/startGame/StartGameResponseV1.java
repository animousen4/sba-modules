package com.animousen4.game.engine.dto.v1.startGame;

import com.animousen4.game.engine.dto.CoreResponse;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class StartGameResponseV1 extends CoreResponse {
    String status;
}

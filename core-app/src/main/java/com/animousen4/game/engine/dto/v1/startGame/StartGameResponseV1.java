package com.animousen4.game.engine.dto.v1.startGame;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.dto.CoreResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class StartGameResponseV1 extends CoreResponse {
    String status;
    GameDTO game;
}

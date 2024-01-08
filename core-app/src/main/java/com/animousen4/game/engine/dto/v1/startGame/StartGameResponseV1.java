package com.animousen4.game.engine.dto.v1.startGame;

import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.dto.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class StartGameResponseV1 extends CoreResponse {
    String status;
    GameModel gameModel;
}

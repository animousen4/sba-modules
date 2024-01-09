package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import com.animousen4.game.engine.core.values.GameStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class StartGameResult extends CoreResult{
    private GameStatus status;
    private GameStoredModel gameStoredModel;
}

package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class StartGameResult extends CoreResult{
    private String status;
    private GameStoredModel gameStoredModel;
}

package com.animousen4.game.engine.core.api.result;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class StartGameResult extends CoreResult{
    private String status;
}

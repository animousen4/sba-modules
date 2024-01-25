package com.animousen4.game.engine.core.api.result;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SoloGameSearchResult extends CoreResult{
    private String requestId;
}

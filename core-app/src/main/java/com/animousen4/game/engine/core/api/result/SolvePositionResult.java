package com.animousen4.game.engine.core.api.result;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SolvePositionResult extends CoreResult{
    String bestMove;
}

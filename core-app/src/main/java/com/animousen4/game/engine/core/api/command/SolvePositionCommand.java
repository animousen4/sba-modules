package com.animousen4.game.engine.core.api.command;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SolvePositionCommand extends CoreCommand{
    String fenPosition;
    Integer depth;
    Long duration;
}

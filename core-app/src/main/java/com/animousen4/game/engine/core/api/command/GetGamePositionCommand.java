package com.animousen4.game.engine.core.api.command;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class GetGamePositionCommand extends CoreCommand{
    Long id;
}

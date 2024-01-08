package com.animousen4.game.engine.core.api.command;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class StartGameCommand extends CoreCommand{
    String name;
}

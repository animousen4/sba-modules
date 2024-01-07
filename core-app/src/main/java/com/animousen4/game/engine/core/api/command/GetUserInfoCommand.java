package com.animousen4.game.engine.core.api.command;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class GetUserInfoCommand extends CoreCommand{
    String username;
}

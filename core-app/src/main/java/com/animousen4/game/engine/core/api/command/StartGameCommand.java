package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.model.game.GameInfo;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class StartGameCommand extends CoreCommand{
    GameInfo gameInfo;
}

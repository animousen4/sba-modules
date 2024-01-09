package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class StartGameCommand extends CoreCommand{
    GameInfoDTO gameInfo;
}

package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.result.StartGameResult;

public interface GameService {
    StartGameResult startGameRequest(StartGameCommand command);
}

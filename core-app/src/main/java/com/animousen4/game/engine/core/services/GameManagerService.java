package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.result.GetGamePositionResult;
import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;

public interface GameManagerService {
    StartGameResult startGame(StartGameCommand command);

    AllCurrentGamesResult getAllCurrentGames();

    GetGamePositionResult getGamePosition(Long id);

    void removeAllCurrentGames();
}

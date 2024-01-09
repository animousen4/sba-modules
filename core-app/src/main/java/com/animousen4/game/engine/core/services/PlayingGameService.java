package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;

public interface PlayingGameService {

    MakeMoveResult makeMove(MakeMoveCommand command);
}

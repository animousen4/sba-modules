package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;
import com.animousen4.game.engine.core.dao.CurrentGameDao;
import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PlayingGameServiceImpl implements PlayingGameService{

    final CurrentGameDao currentGameDao;

    final ValidationErrorFactory validationErrorFactory;
    @Override
    public MakeMoveResult makeMove(MakeMoveCommand command) {
        var curGame = currentGameDao.getCurrentGameById(command.getGameId());

        if (curGame.isPresent())
            return buildMakeMoveGame(command, curGame.get());
        else
            return buildFailMakeMove(command);
    }

    MakeMoveResult buildFailMakeMove(MakeMoveCommand command) {
        return MakeMoveResult.builder()
                //.validationErrors()
                .build();
    }

    MakeMoveResult buildMakeMoveGame(MakeMoveCommand command, GameModel gameModel) {
        return MakeMoveResult.builder()
                //.validationErrors()
                .build();
    }


}

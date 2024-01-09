package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;
import com.animousen4.game.engine.core.dao.CurrentGameDao;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.validator.internal.game.GameMovesValidator;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PlayingGameServiceImpl implements PlayingGameService{

    final GameMovesValidator gameMovesValidator;

    final CurrentGameDao currentGameDao;

    final ValidationErrorFactory validationErrorFactory;
    @Override
    public MakeMoveResult makeMove(MakeMoveCommand command) {
        var errors = gameMovesValidator.validate(command);

        if (errors.isEmpty())
            return buildMakeMoveGame(command);
        else
            return buildFailMakeMove(command, errors);
    }

    MakeMoveResult buildFailMakeMove(MakeMoveCommand command, List<ValidationError> validationErrorList) {

        return MakeMoveResult.builder()
                .validationErrors(validationErrorList)
                .build();
    }

    MakeMoveResult buildMakeMoveGame(MakeMoveCommand command) {
        GameModel game = currentGameDao.getCurrentGameById(command.getGameId()).get();

        return MakeMoveResult.builder()
                .build();
    }


}

package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.mapper.internal.ChessInternalFromStorageGameMapper;
import com.animousen4.game.engine.core.api.model.game.GameInternalModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;
import com.animousen4.game.engine.core.dao.CurrentGameDao;
import com.animousen4.game.engine.core.util.game.MoveUtil;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.validator.internal.game.GameMovesValidator;
import com.animousen4.game.engine.dto.ValidationError;
import com.github.bhlangonijr.chesslib.move.Move;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PlayingGameServiceImpl implements PlayingGameService{

    private final GameMovesValidator gameMovesValidator;

    private final CurrentGameDao currentGameDao;

    private final ChessInternalFromStorageGameMapper gameInternalMapper;

    private final ValidationErrorFactory validationErrorFactory;

    private final MoveUtil moveUtil;

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
        GameInternalModel game = currentGameDao.getCurrentGameById(command.getGameId()).get();


        game.getChessBoardInternalModel().getBoard().doMove(
                moveUtil.getMoveFromString(
                        command.getMoveFrom(),
                        command.getMoveTo()
                )
        );

        currentGameDao.saveGame(game);

        return MakeMoveResult.builder()
                .build();
    }





}

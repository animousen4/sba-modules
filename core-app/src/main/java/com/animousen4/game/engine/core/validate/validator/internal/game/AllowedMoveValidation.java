package com.animousen4.game.engine.core.validate.validator.internal.game;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.dao.CurrentGameDao;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.regex.GameRegex;
import com.animousen4.game.engine.dto.ValidationError;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.game.GameContext;
import com.github.bhlangonijr.chesslib.move.Move;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.animousen4.game.engine.core.consts.AppConsts.*;

@Component
@RequiredArgsConstructor
public class AllowedMoveValidation implements MoveValidation{
    final CurrentGameDao currentGameDao;

    final GameExistValidation gameExistValidation;

    final ValidationErrorFactory validationErrorFactory;

    final GameRegex gameRegex;
    @Override
    public List<ValidationError> validateList(MakeMoveCommand obj) {
        return gameExistValidation.validate(obj).isEmpty()
                ? validateMove(obj)
                : null;
    }

    List<ValidationError> validateMove(MakeMoveCommand obj) {
        List<ValidationError> result = validateCellMove(obj);

        if (result.isEmpty()) {
            validateMovePossibility(obj).ifPresent(result::add);
        }

        return result;
    }

    Optional<ValidationError> validateMovePossibility(MakeMoveCommand obj) {
        var game = currentGameDao.getCurrentGameById(obj.getGameId()).get();
        var board = game.getChessBoardModel().getBoard();
        boolean isLegal = false;

        try {
            isLegal = board.isMoveLegal(
                    new Move(Square.fromValue(obj.getMoveFrom().toUpperCase()),
                            Square.fromValue(obj.getMoveTo().toUpperCase())),
                    false);
        } catch (RuntimeException ignored) {

        }
        return isLegal
                ? Optional.empty()
                : Optional.of(validationErrorFactory.buildError(
                MOVE_NOT_LEGAL,
                List.of(
                        new Placeholder(MOVE_FROM, obj.getMoveFrom()),
                        new Placeholder(MOVE_TO, obj.getMoveTo())
                )
        ))
        ;
    }

    List<ValidationError> validateCellMove(MakeMoveCommand makeMoveCommand) {
        List<ValidationError> errors = new ArrayList<>();

        validateCellSyntax(makeMoveCommand.getMoveFrom()).ifPresent(errors::add);
        validateCellSyntax(makeMoveCommand.getMoveTo()).ifPresent(errors::add);

        return errors;
    }
    Optional<ValidationError> validateCellSyntax(String move) {
        return move.matches(gameRegex.moveRegex)
                ? Optional.empty()
                : Optional.of(
                        validationErrorFactory.buildError(
                                INVALID_MOVE_FORMAT, new Placeholder(MOVE, move)
                        )
                );
    }


    Board setupValidationBoard(String fen) {
        GameContext gameContext = new GameContext();
        gameContext.setStartFEN(fen);
        Board board = new Board();
        board.setContext(gameContext);

        return board;
    }
}

package com.animousen4.game.engine.core.validate.validator.internal.game;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.mapper.internal.ChessInternalFromStorageBoardMapper;
import com.animousen4.game.engine.core.dao.CurrentGameDao;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.util.game.MoveUtil;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.regex.GameRegex;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.animousen4.game.engine.core.values.AppConsts.*;

@Component
@RequiredArgsConstructor
public class AllowedMoveValidation implements MoveValidation{
    private final CurrentGameDao currentGameDao;

    private final GameExistValidation gameExistValidation;

    private final ValidationErrorFactory validationErrorFactory;

    private final ChessInternalFromStorageBoardMapper chessInternalBoardMapper;

    private final GameRegex gameRegex;
    private final MoveUtil moveUtil;
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
        var internalBoard = game.getChessBoardInternalModel();


        boolean isLegal = false;
        try {
            isLegal = internalBoard.getBoard().isMoveLegal(moveUtil.getMoveFromString(
                    obj.getMoveFrom(),
                    obj.getMoveTo()
            ), true);
        } catch (RuntimeException ignore) {

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

}

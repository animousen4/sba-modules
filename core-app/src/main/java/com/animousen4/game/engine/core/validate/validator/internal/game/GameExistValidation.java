package com.animousen4.game.engine.core.validate.validator.internal.game;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.dao.CurrentGameDao;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.animousen4.game.engine.core.values.AppConsts.GAME_ID;
import static com.animousen4.game.engine.core.values.AppConsts.GAME_NOT_EXISTS;

@Component
@RequiredArgsConstructor
class GameExistValidation
        implements MoveValidation {

    final CurrentGameDao currentGameDao;

    final ValidationErrorFactory validationErrorFactory;
    @Override
    public Optional<ValidationError> validate(MakeMoveCommand command) {
        return currentGameDao.getCurrentGameById(command.getGameId()).isPresent()
                ? Optional.empty()
                : Optional.of(validationErrorFactory.buildError(GAME_NOT_EXISTS, new Placeholder(GAME_ID, command.getGameId())));
    }

}

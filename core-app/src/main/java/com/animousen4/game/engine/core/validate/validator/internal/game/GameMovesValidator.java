package com.animousen4.game.engine.core.validate.validator.internal.game;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.validate.validator.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameMovesValidator extends
        AbstractValidator<MakeMoveCommand, MoveValidation> {

    final List<MoveValidation> moveValidations;
    @Override
    protected List<MoveValidation> validationComponentsList() {
        return moveValidations;
    }
}

package com.animousen4.game.engine.core.validate.game.startGame;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.validate.validator.AbstractValidator;
import com.animousen4.game.engine.dto.h1.v1.startGame.StartGameRequestV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartGameValidator extends AbstractValidator<StartGameCommand, StartGameValidation> {

    private final List<StartGameValidation> gameValidations;

    @Override
    protected List<StartGameValidation> validationComponentsList() {
        return gameValidations;
    }
}

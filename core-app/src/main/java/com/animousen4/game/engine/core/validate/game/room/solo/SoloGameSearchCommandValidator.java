package com.animousen4.game.engine.core.validate.game.room.solo;


import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.validate.game.dto.GameInfoDtoValidation;
import com.animousen4.game.engine.core.validate.validator.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SoloGameSearchCommandValidator extends AbstractValidator<SoloGameSearchCommand, GameInfoDtoValidation> {

    private final List<SoloGameSearchCommandValidator> validators;

    @Override
    protected List<GameInfoDtoValidation> validationComponentsList() {
        return null;
    }
}

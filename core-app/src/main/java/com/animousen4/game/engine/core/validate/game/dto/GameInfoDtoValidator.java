package com.animousen4.game.engine.core.validate.game.dto;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.validate.validator.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GameInfoDtoValidator extends AbstractValidator<GameInfoDTO, GameInfoDtoValidation> {

    private final GameInfoDtoValidation gameInfoDtoValidation;
    @Override
    protected List<GameInfoDtoValidation> validationComponentsList() {
        return List.of(gameInfoDtoValidation);
    }
}

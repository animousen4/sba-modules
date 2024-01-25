package com.animousen4.game.engine.core.validate.game.room.solo;

import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.validate.AbstractDefaultValidation;
import com.animousen4.game.engine.core.validate.chaining.PrettyValidationErrorChaining;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SoloGameSearchValidation implements AbstractDefaultValidation<SoloGameSearchCommand> {

    private final MandatoryMicroValidator mandatoryMicroValidator;
    @Override
    public List<ValidationError> validateList(SoloGameSearchCommand command) {
        var errors = PrettyValidationErrorChaining.start()
                .go(command::getSoloGameInfoModel, x -> mandatoryMicroValidator.validate(x, "gameInfo"))
                .parallel(
                        v -> v.go(() -> command.getSoloGameInfoModel().getGameDifficulty(), x -> mandatoryMicroValidator.validate(x, "difficulty"))
                )
                .parallel(
                        v -> v.go(() -> command.getSoloGameInfoModel().getOpponentModel(), x -> mandatoryMicroValidator.validate(x, "opponent"))
                )
                .parallel(
                        v -> v.go(() -> command.getSoloGameInfoModel().getPlayerColorModel(), x -> mandatoryMicroValidator.validate(x, "color"))
                )
                .validate();
        return errors;
    }
}

package com.animousen4.game.engine.core.validate.validator.internal.game;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.validate.chaining.ValidationChaining;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartGameGameInfoValidation implements StartGameValidation {

    private final MandatoryMicroValidator mandatoryMicroValidator;

    @Override
    public List<ValidationError> validateList(StartGameCommand gameCommand) {
        return ValidationChaining.start()
                .goNext(gameCommand::getGameInfo, x -> mandatoryMicroValidator.validate(x, "gameInfo"))
                    .startParallel()
                        .goNextIfOk(() -> gameCommand.getGameInfo().getBlackSide(), x -> mandatoryMicroValidator.validate(x, "blackSide"))
                    .endParallel()
                    .startParallel()
                        .goNextIfOk(() -> gameCommand.getGameInfo().getWhiteSide(), x -> mandatoryMicroValidator.validate(x, "whiteSide"))
                    .endParallel()
                .validate();
    }
}

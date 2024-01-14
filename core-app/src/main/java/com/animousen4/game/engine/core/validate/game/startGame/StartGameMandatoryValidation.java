package com.animousen4.game.engine.core.validate.game.startGame;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.util.error.NullCheckUtil;
import com.animousen4.game.engine.core.validate.chaining.PrettyValidationErrorChaining;
import com.animousen4.game.engine.core.validate.game.dto.GameInfoDtoValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartGameMandatoryValidation implements StartGameValidation{

    private final NullCheckUtil nullCheckUtil;

    private final GameInfoDtoValidator gameInfoDtoValidator;

    @Override
    public List<ValidationError> validateList(StartGameCommand obj) {
        return PrettyValidationErrorChaining.start()
                .go(obj::getGameInfo, x -> nullCheckUtil.checkForNull(x, "gameInfo"))
                .goList(obj::getGameInfo, gameInfoDtoValidator::validate)
                .validate();
    }

}

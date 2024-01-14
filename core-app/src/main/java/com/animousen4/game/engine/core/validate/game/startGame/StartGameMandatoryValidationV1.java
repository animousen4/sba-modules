package com.animousen4.game.engine.core.validate.game.startGame;

import com.animousen4.game.engine.core.util.error.NullCheckUtil;
import com.animousen4.game.engine.core.validate.chaining.PrettyValidationErrorChaining;
import com.animousen4.game.engine.core.validate.game.dto.GameInfoDtoValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import com.animousen4.game.engine.dto.h1.v1.startGame.StartGameRequestV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartGameMandatoryValidationV1 implements StartGameValidation{

    private final NullCheckUtil nullCheckUtil;

    private final GameInfoDtoValidator gameInfoDtoValidator;

    @Override
    public List<ValidationError> validateList(StartGameRequestV1 obj) {
        return PrettyValidationErrorChaining.start()
                .go(obj::getGameInfo, x -> nullCheckUtil.checkForNull(x, "gameInfo"))
                .goList(obj::getGameInfo, gameInfoDtoValidator::validate)
                .validate();
    }

}

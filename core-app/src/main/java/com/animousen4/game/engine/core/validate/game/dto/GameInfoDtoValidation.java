package com.animousen4.game.engine.core.validate.game.dto;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.util.error.NullCheckUtil;
import com.animousen4.game.engine.core.validate.AbstractDefaultValidation;
import com.animousen4.game.engine.core.validate.chaining.PrettyValidationErrorChaining;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameInfoDtoValidation implements AbstractDefaultValidation<GameInfoDTO> {

    private final NullCheckUtil nullCheckUtil;
    @Override
    public List<ValidationError> validateList(GameInfoDTO obj) {
        return PrettyValidationErrorChaining.start()
                .parallel(
                        validBlack -> validBlack.go(
                                obj::getBlackSide,
                                x -> nullCheckUtil.checkForNull(x, "blackSide")
                        )
                )
                .parallel(
                        validWhite -> validWhite.go(
                                obj::getWhiteSide,
                                x -> nullCheckUtil.checkForNull(x, "whiteSide")
                        )
                )
                .validate();
    }
}

package com.animousen4.game.engine.core.validate.game.startGame;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.util.error.NullCheckUtil;
import com.animousen4.game.engine.core.validate.game.dto.GameInfoDtoValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import com.animousen4.game.engine.dto.h1.v1.startGame.StartGameRequestV1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StartGameMandatoryValidationV1Test {

    @Mock
    GameInfoDtoValidator gameInfoDtoValidator;

    @Mock
    NullCheckUtil nullCheckUtil;

    @InjectMocks
    StartGameMandatoryValidationV1 mandatoryValidationV1;


    @Test
    void testGameInfoMandatoryNoErrors() {

        StartGameRequestV1 requestV1 = mock();
        GameInfoDTO gameInfoDTO = mock();

        when(requestV1.getGameInfo()).thenReturn(gameInfoDTO);


        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.empty());
        when(gameInfoDtoValidator.validate(gameInfoDTO)).thenReturn(List.of());

        List<ValidationError> errors = mandatoryValidationV1.validateList(requestV1);

        assertEquals(0, errors.size());
    }

    @Test
    void testGameInfoMandatoryGameInfoEmpty() {

        StartGameRequestV1 requestV1 = mock();
        GameInfoDTO gameInfoDTO = mock();
        ValidationError validationError = mock();
        when(requestV1.getGameInfo()).thenReturn(gameInfoDTO);

        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.of(validationError));

        List<ValidationError> errors = mandatoryValidationV1.validateList(requestV1);

        assertEquals(1, errors.size());
    }

    @Test
    void testGameInfoMandatoryHasGameInfoErrors() {

        StartGameRequestV1 requestV1 = mock();
        GameInfoDTO gameInfoDTO = mock();
        ValidationError validationError = mock();

        when(requestV1.getGameInfo()).thenReturn(gameInfoDTO);

        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.empty());
        when(gameInfoDtoValidator.validate(gameInfoDTO)).thenReturn(List.of(validationError));

        List<ValidationError> errors = mandatoryValidationV1.validateList(requestV1);

        assertEquals(1, errors.size());
    }
}

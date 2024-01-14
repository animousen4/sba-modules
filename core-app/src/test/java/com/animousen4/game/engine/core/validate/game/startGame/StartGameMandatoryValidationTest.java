package com.animousen4.game.engine.core.validate.game.startGame;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.util.error.NullCheckUtil;
import com.animousen4.game.engine.core.validate.game.dto.GameInfoDtoValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
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
public class StartGameMandatoryValidationTest {

    @Mock
    GameInfoDtoValidator gameInfoDtoValidator;

    @Mock
    NullCheckUtil nullCheckUtil;

    @InjectMocks
    StartGameMandatoryValidation mandatoryValidationV1;


    @Test
    void testGameInfoMandatoryNoErrors() {

        StartGameCommand command = mock();
        GameInfoDTO gameInfoDTO = mock();

        when(command.getGameInfo()).thenReturn(gameInfoDTO);


        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.empty());
        when(gameInfoDtoValidator.validate(gameInfoDTO)).thenReturn(List.of());

        List<ValidationError> errors = mandatoryValidationV1.validateList(command);

        assertEquals(0, errors.size());
    }

    @Test
    void testGameInfoMandatoryGameInfoEmpty() {

        StartGameCommand command = mock();
        GameInfoDTO gameInfoDTO = mock();
        ValidationError validationError = mock();
        when(command.getGameInfo()).thenReturn(gameInfoDTO);

        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.of(validationError));

        List<ValidationError> errors = mandatoryValidationV1.validateList(command);

        assertEquals(1, errors.size());
    }

    @Test
    void testGameInfoMandatoryHasGameInfoErrors() {

        StartGameCommand command = mock();
        GameInfoDTO gameInfoDTO = mock();
        ValidationError validationError = mock();

        when(command.getGameInfo()).thenReturn(gameInfoDTO);

        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.empty());
        when(gameInfoDtoValidator.validate(gameInfoDTO)).thenReturn(List.of(validationError));

        List<ValidationError> errors = mandatoryValidationV1.validateList(command);

        assertEquals(1, errors.size());
    }

    @Test
    void testGameInfoMandatoryHasSeveralGameInfoErrors() {

        StartGameCommand command = mock();
        GameInfoDTO gameInfoDTO = mock();
        ValidationError validationError = mock();

        when(command.getGameInfo()).thenReturn(gameInfoDTO);

        when(nullCheckUtil.checkForNull(eq(gameInfoDTO), eq("gameInfo"))).thenReturn(Optional.empty());
        when(gameInfoDtoValidator.validate(gameInfoDTO)).thenReturn(List.of(validationError, validationError));

        List<ValidationError> errors = mandatoryValidationV1.validateList(command);

        assertEquals(2, errors.size());
    }
}

package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.api.dto.user.UserDto;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SignUpMandatoryValidatorTest {

    @Mock
    MandatoryMicroValidator mandatoryMicroValidator;

    @Mock
    UserDtoMandatoryValidator userDtoMandatoryValidator;

    @InjectMocks
    SignUpMandatoryValidator signUpMandatoryValidator;

    @Test
    void testSignUpMandatoryAllOk() {
        SignUpCommand command = mock();
        UserDto user = mock();

        when(command.getUser()).thenReturn(user);
        when(userDtoMandatoryValidator.validate(eq(user))).thenReturn(List.of());
        when(mandatoryMicroValidator.validate(eq(user), eq("user"))).thenReturn(Optional.empty());

        List<ValidationError> errors = signUpMandatoryValidator.validate(command);

        assertTrue(errors.isEmpty());

    }

    @Test
    void testSignUpMandatoryMainFieldMissing() {
        SignUpCommand command = mock();
        ValidationError validationError = mock();
        UserDto user = mock();

        when(command.getUser()).thenReturn(user);
        when(mandatoryMicroValidator.validate(eq(user), eq("user"))).thenReturn(Optional.of(validationError));

        List<ValidationError> errors = signUpMandatoryValidator.validate(command);

        assertEquals(1, errors.size());

    }

    @Test
    void testSignUpMandatoryListError() {
        SignUpCommand command = mock();
        ValidationError validationError = mock();
        UserDto user = mock();

        when(command.getUser()).thenReturn(user);
        when(userDtoMandatoryValidator.validate(eq(user))).thenReturn(List.of(validationError, validationError));
        when(mandatoryMicroValidator.validate(eq(user), eq("user"))).thenReturn(Optional.empty());

        List<ValidationError> errors = signUpMandatoryValidator.validate(command);

        assertEquals(2, errors.size());

    }
}

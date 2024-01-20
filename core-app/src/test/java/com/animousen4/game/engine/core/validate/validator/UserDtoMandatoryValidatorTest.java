package com.animousen4.game.engine.core.validate.validator;

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDtoMandatoryValidatorTest {

    @Mock
    MandatoryMicroValidator mandatoryMicroValidator;

    @InjectMocks
    UserDtoMandatoryValidator userDtoMandatoryValidator;

    @Test
    void testAllOk() {

        UserDto dto = mock();
        String m = "m";

        when(dto.getEmail()).thenReturn(m);
        when(dto.getUsername()).thenReturn(m);
        when(dto.getPassword()).thenReturn(m);

        when(mandatoryMicroValidator.validate(eq(m), eq("username"))).thenReturn(Optional.empty());
        when(mandatoryMicroValidator.validate(eq(m), eq("password"))).thenReturn(Optional.empty());
        when(mandatoryMicroValidator.validate(eq(m), eq("email"))).thenReturn(Optional.empty());

        List<ValidationError> errors = userDtoMandatoryValidator.validate(dto);

        assertEquals(0, errors.size());
    }

    @Test
    void testAllMandatoryEmpty() {

        UserDto dto = mock();
        String m = null;
        ValidationError validationError = mock();

        when(dto.getEmail()).thenReturn(m);
        when(dto.getUsername()).thenReturn(m);
        when(dto.getPassword()).thenReturn(m);

        when(mandatoryMicroValidator.validate(eq(m), eq("username"))).thenReturn(Optional.of(validationError));
        when(mandatoryMicroValidator.validate(eq(m), eq("password"))).thenReturn(Optional.of(validationError));
        when(mandatoryMicroValidator.validate(eq(m), eq("email"))).thenReturn(Optional.of(validationError));

        List<ValidationError> errors = userDtoMandatoryValidator.validate(dto);

        assertEquals(3, errors.size());
    }

    @Test
    void testMandatoryPasswordEmpty() {

        UserDto dto = mock();
        String m = null;
        ValidationError validationError = mock();

        when(dto.getEmail()).thenReturn(m);
        when(dto.getUsername()).thenReturn(m);
        when(dto.getPassword()).thenReturn(m);

        when(mandatoryMicroValidator.validate(eq(m), eq("username"))).thenReturn(Optional.empty());
        when(mandatoryMicroValidator.validate(eq(m), eq("password"))).thenReturn(Optional.of(validationError));
        when(mandatoryMicroValidator.validate(eq(m), eq("email"))).thenReturn(Optional.empty());

        List<ValidationError> errors = userDtoMandatoryValidator.validate(dto);

        assertEquals(1, errors.size());
    }
}

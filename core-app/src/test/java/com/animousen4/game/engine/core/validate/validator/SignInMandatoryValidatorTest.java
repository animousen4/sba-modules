package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SignInMandatoryValidatorTest {

    @Mock
    MandatoryMicroValidator mandatoryMicroValidator;

    @InjectMocks
    SignInMandatoryValidator signInMandatoryValidator;


    @Test
    void testMandatoryUserNamePasswordAllOk() {
        SignInCommand command = mock();

        when(command.getUsername()).thenReturn("u");
        when(command.getPassword()).thenReturn("p");

        when(mandatoryMicroValidator.validate(eq("u"), eq("username"))).thenReturn(Optional.empty());
        when(mandatoryMicroValidator.validate(eq("p"), eq("password"))).thenReturn(Optional.empty());

        assertTrue(signInMandatoryValidator.validate(command).isEmpty());

    }

    @Test
    void testMandatoryUserNamePasswordOneNotPresent() {
        SignInCommand command = mock();
        ValidationError error = mock();
        when(command.getUsername()).thenReturn("u");
        when(command.getPassword()).thenReturn("p");

        when(mandatoryMicroValidator.validate(eq("u"), eq("username"))).thenReturn(Optional.of(error));
        when(mandatoryMicroValidator.validate(eq("p"), eq("password"))).thenReturn(Optional.empty());

        assertEquals(1, signInMandatoryValidator.validate(command).size());

    }

    @Test
    void testMandatoryUserNamePasswordOneOtherNotPresent() {
        SignInCommand command = mock();
        ValidationError error = mock();
        when(command.getUsername()).thenReturn("u");
        when(command.getPassword()).thenReturn("p");

        when(mandatoryMicroValidator.validate(eq("u"), eq("username"))).thenReturn(Optional.empty());
        when(mandatoryMicroValidator.validate(eq("p"), eq("password"))).thenReturn(Optional.of(error));

        assertEquals(1, signInMandatoryValidator.validate(command).size());

    }

    @Test
    void testMandatoryUserNamePasswordBothNotPresent() {
        SignInCommand command = mock();
        ValidationError error = mock();
        when(command.getUsername()).thenReturn("u");
        when(command.getPassword()).thenReturn("p");

        when(mandatoryMicroValidator.validate(eq("u"), eq("username"))).thenReturn(Optional.of(error));
        when(mandatoryMicroValidator.validate(eq("p"), eq("password"))).thenReturn(Optional.of(error));

        assertEquals(2, signInMandatoryValidator.validate(command).size());

    }
}

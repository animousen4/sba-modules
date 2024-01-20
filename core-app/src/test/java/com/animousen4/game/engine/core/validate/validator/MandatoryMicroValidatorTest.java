package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.description.MandatoryFieldMissing;
import com.animousen4.game.engine.core.validate.validator.micro.MandatoryMicroValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MandatoryMicroValidatorTest {

    @Mock
    ValidationErrorFactory validationErrorFactory;

    @InjectMocks
    MandatoryMicroValidator mandatoryMicroValidator;

    @Test
    void testEmpty() {
        ValidationError error = mock();
        String ent = null;
        when(validationErrorFactory.buildError((MandatoryFieldMissing) any())).thenReturn(error);

        assertTrue(mandatoryMicroValidator.validate(ent, "a").isPresent());
    }

    @Test
    void testAllOk() {

        String ent = "m";

        assertTrue(mandatoryMicroValidator.validate(ent, "a").isEmpty());
    }
}

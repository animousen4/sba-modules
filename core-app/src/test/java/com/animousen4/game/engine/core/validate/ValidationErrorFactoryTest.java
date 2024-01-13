package com.animousen4.game.engine.core.validate;

import com.animousen4.game.engine.core.util.ErrorCodeUtil;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.description.ErrorPair;
import com.animousen4.game.engine.dto.h1.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ValidationErrorFactoryTest {

    private final String code = "CODE";
    private final String description = "DESCRIPTION";
    @Mock
    ErrorCodeUtil errorCodeUtil;

    @InjectMocks
    ValidationErrorFactory validationErrorFactory;


    @Test
    void testBuildErrorByErrorCode() {
        when(errorCodeUtil.getErrorDescription(eq(code))).thenReturn(description);

        ValidationError error = validationErrorFactory.buildError(code);

        assertEquals(code, error.getErrorCode());
        assertEquals(description, error.getDescription());
    }

    @Test
    void testBuildErrorByErrorCodeAndPlaceholderList() {
        Placeholder placeholder =  mock(Placeholder.class);
        List<Placeholder> placeholderList = List.of(placeholder);


        when(errorCodeUtil.getErrorDescription(eq(code), eq(placeholderList))).thenReturn(description);


        ValidationError error = validationErrorFactory.buildError(code, placeholderList);

        assertEquals(code, error.getErrorCode());
        assertEquals(description, error.getDescription());
    }

    @Test
    void testBuildErrorByErrorCodeAndOnePlaceholder() {
        Placeholder placeholder =  mock(Placeholder.class);
        List<Placeholder> placeholderList = List.of(placeholder);

        when(errorCodeUtil.getErrorDescription(eq(code), eq(placeholderList))).thenReturn(description);

        ValidationError error = validationErrorFactory.buildError(code, placeholder);

        assertEquals(code, error.getErrorCode());
        assertEquals(description, error.getDescription());
    }

    @Test
    void testBuildErrorByErrorPair() {
        ErrorPair errorPair = mock(ErrorPair.class);
        List<Placeholder> placeholderList = List.of(mock(Placeholder.class));

        when(errorCodeUtil.getErrorDescription(eq(code), eq(placeholderList))).thenReturn(description);
        when(errorPair.getPlaceholderList()).thenReturn(placeholderList);
        when(errorPair.getErrorCode()).thenReturn(code);

        ValidationError error = validationErrorFactory.buildError(errorPair);

        assertEquals(code, error.getErrorCode());
        assertEquals(description, error.getDescription());
    }
}

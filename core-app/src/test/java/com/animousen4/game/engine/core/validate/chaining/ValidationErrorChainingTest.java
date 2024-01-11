package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.h1.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ValidationErrorChainingTest {
    @Test
    void testZeroValidation() {
        List<ValidationError> errors = ValidationErrorChaining.start()
                .validate();

        assertTrue(errors.isEmpty());
    }

    @Test
    void testOneValidationNoErrors() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> x == 0 ? Optional.empty() : Optional.of(m))
                .validate();

        assertTrue(errors.isEmpty());
    }

    @Test
    void testOneValidationHasErrors() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> x == 1 ? Optional.empty() : Optional.of(m))
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testOneValidationDontGoNextAfterError() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> x == 1 ? Optional.empty() : Optional.of(m))
                .goIfOk(() -> data, x -> x == 2 ? Optional.empty() : Optional.of(m))
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testOneValidationDontGoNextAfterDouble() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> x == 1 ? Optional.empty() : Optional.of(m))
                .goIfOk(() -> data, x -> x == 2 ? Optional.empty() : Optional.of(m))
                .goIfOk(() -> data, x -> x == 3 ? Optional.empty() : Optional.of(m))
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testOneValidationDontGoAfterSecondAndAfterFirstOk() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> x == 0 ? Optional.empty() : Optional.of(m))
                .goIfOk(() -> data, x -> x == 2 ? Optional.empty() : Optional.of(m))
                .goIfOk(() -> data, x -> x == 3 ? Optional.empty() : Optional.of(m))
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testTwoValidationParallel() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .startParallel()
                    .go(() -> data, x -> x == 2 ? Optional.empty() : Optional.of(m))
                .endParallel()
                .startParallel()
                    .go(() -> data, x -> x == 3 ? Optional.empty() : Optional.of(m))
                .endParallel()
                .validate();

        assertEquals(2, errors.size());
    }

    /*@Test
    void testTwoValidationParallelFailsWhenFirst() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> Optional.of(m))
                .startParallel()
                    .go(() -> data, x -> x == 2 ? Optional.empty() : Optional.of(m))
                .endParallel()
                .startParallel()
                    .go(() -> data, x -> x == 3 ? Optional.empty() : Optional.of(m))
                .endParallel()
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testNestedValidationParallel() {
        ValidationError m = mock(ValidationError.class);
        int data = 0;
        List<ValidationError> errors = ValidationErrorChaining.start()
                .go(() -> data, x -> Optional.empty())
                .startParallel()
                    .startParallel()
                        .go(() -> data, x -> Optional.of(m))
                    .endParallel()
                    .startParallel()
                        .go(() -> data, x->Optional.of(m))
                    .endParallel()
                .endParallel()
                .startParallel()
                    .go(() -> data, x -> Optional.of(m))
                .endParallel()
                .validate();

        assertEquals(3, errors.size());
    }*/
}

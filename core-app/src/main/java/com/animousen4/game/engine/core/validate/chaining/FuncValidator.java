package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.ValidationError;

import java.util.Optional;

@FunctionalInterface
public interface FuncValidator<T> {
    Optional<ValidationError> validate(T toValidate);
}
package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.ValidationError;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface FuncValidator<V, T> {
    Optional<V> validate(T toValidate);
}
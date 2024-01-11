package com.animousen4.game.engine.core.validate.chaining;

import java.util.Optional;

@FunctionalInterface
public interface FuncValidator<V, T> {
    Optional<V> validate(T toValidate);
}
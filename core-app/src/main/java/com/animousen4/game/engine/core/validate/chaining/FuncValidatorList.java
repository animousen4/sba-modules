package com.animousen4.game.engine.core.validate.chaining;

import java.util.List;

@FunctionalInterface
public interface FuncValidatorList<V, T> {
    List<V> validate(T toValidate);
}
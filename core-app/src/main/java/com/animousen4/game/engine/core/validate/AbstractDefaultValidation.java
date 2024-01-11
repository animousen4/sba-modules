package com.animousen4.game.engine.core.validate;

import com.animousen4.game.engine.dto.h1.ValidationError;

import java.util.List;
import java.util.Optional;

public interface AbstractDefaultValidation<T> extends AbstractValidation<T> {
    @Override
    default Optional<ValidationError> validate(T obj) {
        return Optional.empty();
    }

    @Override
    default List<ValidationError> validateList(T obj) {
        return null;
    }
}

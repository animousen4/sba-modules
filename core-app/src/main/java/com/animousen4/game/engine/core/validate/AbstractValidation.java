package com.animousen4.game.engine.core.validate;

import com.animousen4.game.engine.dto.h1.ValidationError;

import java.util.List;
import java.util.Optional;

public interface AbstractValidation<T> {
    Optional<ValidationError> validate(T obj);

    List<ValidationError> validateList(T obj);
}

package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;

import java.util.List;
import java.util.Optional;

public interface AbstractValidation<T> {
    Optional<ValidationError> validate(T obj);

    List<ValidationError> validateList(T obj);
}

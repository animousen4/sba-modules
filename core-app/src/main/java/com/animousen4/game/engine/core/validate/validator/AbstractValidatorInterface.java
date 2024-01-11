package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.dto.h1.ValidationError;

import java.util.List;

public interface AbstractValidatorInterface<T>{
    List<ValidationError> validate(T entity);
}

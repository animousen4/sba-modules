package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;

import java.util.List;

public interface AbstractValidator<T>{
    List<ValidationError> validate(T entity);
}

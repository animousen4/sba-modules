package com.animousen4.game.engine.core.validations.flux;

import com.animousen4.game.engine.dto.ValidationError;
import reactor.core.publisher.Flux;

public interface AbstractValidationV2<T> {
    Flux<ValidationError> validate(T object);
}

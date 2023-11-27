package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SomeRequestV1;

import java.util.List;
import java.util.Optional;

public interface PositionValidation {
    Optional<ValidationError> validate(SomeRequestV1 request);

    List<ValidationError> validateList(SomeRequestV1 request);
}

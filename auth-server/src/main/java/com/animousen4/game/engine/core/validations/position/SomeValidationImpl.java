package com.animousen4.game.engine.core.validations.position;

import com.animousen4.game.engine.core.validations.PositionValidation;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SomeRequestV1;

import java.util.List;
import java.util.Optional;


abstract class SomeValidationImpl implements PositionValidation {
    @Override
    public abstract Optional<ValidationError> validate(SomeRequestV1 request);

    @Override
    public List<ValidationError> validateList(SomeRequestV1 request) {
        return null;
    }
}

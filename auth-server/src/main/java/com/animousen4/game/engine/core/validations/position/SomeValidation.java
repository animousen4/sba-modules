package com.animousen4.game.engine.core.validations.position;

import com.animousen4.game.engine.core.validations.ValidationErrorFactory;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SomeRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class SomeValidation extends SomeValidationImpl {
    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> validate(SomeRequestV1 request) {
        return Optional.empty();
    }
}

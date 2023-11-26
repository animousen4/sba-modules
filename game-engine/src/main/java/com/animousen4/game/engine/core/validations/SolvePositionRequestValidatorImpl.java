package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
class SolvePositionRequestValidatorImpl implements SolvePositionRequestValidator {

    @Autowired
    List<PositionValidation>  positionValidations;
    @Override
    public List<ValidationError> validate(SolvePositionRequestV1 request) {
        return collectPositionErrors(request);
    }

    public List<ValidationError> collectPositionErrors(SolvePositionRequestV1 request) {
        return positionValidations.stream()
                .map(validation -> validation.validate(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}

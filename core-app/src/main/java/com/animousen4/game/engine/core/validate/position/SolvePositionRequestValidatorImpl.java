package com.animousen4.game.engine.core.validate.position;

import com.animousen4.game.engine.core.validate.PositionValidation;
import com.animousen4.game.engine.core.validate.validator.SolvePositionRequestValidator;
import com.animousen4.game.engine.dto.h1.ValidationError;
import com.animousen4.game.engine.dto.h1.v1.solvePosition.SolvePositionRequestV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class SolvePositionRequestValidatorImpl implements SolvePositionRequestValidator {

    private final List<PositionValidation>  positionValidations;
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

package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SolvePositionRequestV1;

import java.util.List;
import java.util.Optional;

public interface PositionValidation extends AbstractValidation<SolvePositionRequestV1> {
    Optional<ValidationError> validate(SolvePositionRequestV1 obj);

    List<ValidationError> validateList(SolvePositionRequestV1 obj);
}

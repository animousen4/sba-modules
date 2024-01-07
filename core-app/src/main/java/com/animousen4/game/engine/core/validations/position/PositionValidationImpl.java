package com.animousen4.game.engine.core.validations.position;

import com.animousen4.game.engine.core.validations.PositionValidation;
import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionRequestV1;

import java.util.List;
import java.util.Optional;


abstract class PositionValidationImpl implements PositionValidation {
    @Override
    public abstract Optional<ValidationError> validate(SolvePositionRequestV1 obj);

    @Override
    public List<ValidationError> validateList(SolvePositionRequestV1 obj) {
        return null;
    }
}

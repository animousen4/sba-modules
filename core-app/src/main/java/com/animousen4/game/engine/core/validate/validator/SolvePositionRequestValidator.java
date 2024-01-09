package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.solvePosition.SolvePositionRequestV1;

import java.util.List;

public interface SolvePositionRequestValidator {
    List<ValidationError> validate(SolvePositionRequestV1 request);
}

package com.animousen4.game.engine.core.validate.validator;

import com.animousen4.game.engine.dto.h1.ValidationError;
import com.animousen4.game.engine.dto.h1.v1.solvePosition.SolvePositionRequestV1;

import java.util.List;

public interface SolvePositionRequestValidator {
    List<ValidationError> validate(SolvePositionRequestV1 request);
}

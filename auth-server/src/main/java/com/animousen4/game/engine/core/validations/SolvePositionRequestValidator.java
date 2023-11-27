package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.ValidationError;
import com.animousen4.game.engine.dto.v1.SomeRequestV1;

import java.util.List;

public interface SolvePositionRequestValidator {
    List<ValidationError> validate(SomeRequestV1 request);
}

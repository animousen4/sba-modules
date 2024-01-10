package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.ValidationError;

public class PrettyValidationErrorChaining extends PrettyValidationChaining<ValidationError>{
    public static PrettyValidationChaining<ValidationError> start() {
        return new PrettyValidationChaining<>();
    }
}

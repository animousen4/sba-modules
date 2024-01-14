package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.h1.ValidationError;

@Deprecated
public class ValidationErrorChaining extends ValidationChaining<ValidationError>{

    public static ValidationChaining<ValidationError> start() {
        return new ValidationChaining<>();
    }
}

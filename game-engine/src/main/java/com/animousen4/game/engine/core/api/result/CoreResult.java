package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.dto.ValidationError;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public abstract class CoreResult {
    List<ValidationError> validationErrors;

    public boolean hasErrors() {
        return  validationErrors != null && !validationErrors.isEmpty();
    }
}

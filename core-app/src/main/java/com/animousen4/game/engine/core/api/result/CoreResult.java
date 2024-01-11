package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@AllArgsConstructor
public abstract class CoreResult {
    List<ValidationError> validationErrors;

    public boolean hasErrors() {
        return  validationErrors != null && !validationErrors.isEmpty();
    }


}

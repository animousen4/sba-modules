package com.animousen4.game.engine.core.validations.common.mandatory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MandatoryField {
    private Object object;
    private String fieldName;

    boolean exist() {
        return object != null;
    }
}

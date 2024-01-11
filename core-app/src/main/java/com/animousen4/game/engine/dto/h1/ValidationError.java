package com.animousen4.game.engine.dto.h1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {
    private String errorCode;
    private String description;

    @Override
    public String toString() {
        return "%s : %s".formatted(errorCode, description);
    }
}
package com.animousen4.game.engine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CoreResponse {
    private List<ValidationError> errors;

    public CoreResponse(List<ValidationError> errors) {
        this.errors = errors;
    }

}

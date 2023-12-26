package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.dto.CoreResponse;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@NoArgsConstructor
@SuperBuilder
public class SomeResponseV1 extends CoreResponse {
    public SomeResponseV1(List<ValidationError> errors) {
        super(errors);
    }
}

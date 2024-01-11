package com.animousen4.game.engine.dto.h1.v1.solvePosition;

import com.animousen4.game.engine.dto.h1.CoreResponse;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SolvePositionResponseV1 extends CoreResponse {

    String bestMove;
    List<String> bestMoveVariant;
    public SolvePositionResponseV1(List<ValidationError> errors) {
        super(errors);
    }
}

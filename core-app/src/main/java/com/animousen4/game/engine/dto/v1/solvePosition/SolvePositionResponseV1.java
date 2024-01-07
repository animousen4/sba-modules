package com.animousen4.game.engine.dto.v1.solvePosition;

import com.animousen4.game.engine.dto.CoreResponse;
import com.animousen4.game.engine.dto.ValidationError;
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

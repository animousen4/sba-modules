package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.dto.CoreResponse;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolvePositionResponseV1 extends CoreResponse {

    String bestMove;
    List<String> bestMoveVariant;
    public SolvePositionResponseV1(List<ValidationError> errors) {
        super(errors);
    }
}

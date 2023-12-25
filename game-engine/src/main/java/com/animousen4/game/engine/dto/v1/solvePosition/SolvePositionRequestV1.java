package com.animousen4.game.engine.dto.v1.solvePosition;

import com.animousen4.game.engine.dto.CoreRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolvePositionRequestV1 extends CoreRequest {
    private String fenPosition;
}

package com.animousen4.game.engine.dto.h1.v1.solvePosition;

import com.animousen4.game.engine.dto.h1.CoreRequest;
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
    private Integer depth;
    private Long duration;
}

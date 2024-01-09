package com.animousen4.game.engine.dto.v1.makeMove;

import com.animousen4.game.engine.dto.CoreRequest;
import lombok.Getter;

@Getter
public class MakeMoveRequestV1 extends CoreRequest {
    private String moveFrom;
    private String moveTo;
    private Long gameId;
}

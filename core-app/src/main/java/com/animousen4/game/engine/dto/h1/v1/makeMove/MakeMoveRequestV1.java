package com.animousen4.game.engine.dto.h1.v1.makeMove;

import com.animousen4.game.engine.dto.h1.CoreRequest;
import lombok.Getter;

@Getter
public class MakeMoveRequestV1 extends CoreRequest {
    private String moveFrom;
    private String moveTo;
    private Long gameId;
}

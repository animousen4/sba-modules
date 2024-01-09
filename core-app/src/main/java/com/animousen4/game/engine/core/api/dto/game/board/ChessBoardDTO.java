package com.animousen4.game.engine.core.api.dto.game.board;

import com.animousen4.game.engine.core.api.model.game.board.BoardSide;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ChessBoardDTO {
    String fen;

    BoardSide whiteSide;
    BoardSide blackSide;
}

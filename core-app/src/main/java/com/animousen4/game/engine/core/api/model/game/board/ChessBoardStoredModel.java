package com.animousen4.game.engine.core.api.model.game.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ChessBoardStoredModel {
    String fen;

    BoardSide whiteSide;
    BoardSide blackSide;

}

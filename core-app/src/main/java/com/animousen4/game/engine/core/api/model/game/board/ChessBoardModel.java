package com.animousen4.game.engine.core.api.model.game.board;

import com.github.bhlangonijr.chesslib.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ChessBoardModel {
    Board board;

    BoardSide whiteSide;
    BoardSide blackSide;

}

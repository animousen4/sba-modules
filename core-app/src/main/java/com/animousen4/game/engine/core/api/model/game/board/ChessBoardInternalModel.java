package com.animousen4.game.engine.core.api.model.game.board;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ChessBoardInternalModel {
    public Board board;

    private BoardSide whiteSide;
    private BoardSide blackSide;

}

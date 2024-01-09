package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.model.game.GameInfoModel;
import com.animousen4.game.engine.core.api.model.game.board.BoardSide;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardModel;
import com.github.bhlangonijr.chesslib.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessBoardModelFactory {
    final Board board = new Board();
    public ChessBoardModel createNewClassicModel(GameInfoModel gameInfo) {
        return ChessBoardModel.builder()
                .fen(board.getFen())
                .whiteSide(
                        BoardSide.builder()
                                .chessClock(gameInfo.getWhiteSide().getClock())
                                .takenPieces(List.of())
                                .build()
                )
                .blackSide(
                        BoardSide.builder()
                                .chessClock(gameInfo.getBlackSide().getClock())
                                .takenPieces(List.of())
                                .build()
                )
                .build();
    }
}

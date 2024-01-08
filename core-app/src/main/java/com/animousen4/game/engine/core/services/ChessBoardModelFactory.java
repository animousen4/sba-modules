package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.model.game.GameInfo;
import com.animousen4.game.engine.core.api.model.game.board.BoardSide;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardModel;
import com.github.bhlangonijr.chesslib.Board;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ChessBoardModelFactory {
    final Board board = new Board();
    public ChessBoardModel createNewClassicModel(GameInfo gameInfo) {
        return ChessBoardModel.builder()
                .fen(board.getFen())
                .whiteSide(
                        BoardSide.builder()
                                .leftTime(gameInfo.getDuration())
                                .takenPieces(List.of())
                                .build()
                )
                .blackSide(
                        BoardSide.builder()
                                .leftTime(gameInfo.getDuration())
                                .takenPieces(List.of())
                                .build()
                )
                .build();
    }
}

package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.model.game.GameInfoModel;
import com.animousen4.game.engine.core.api.model.game.board.BoardSide;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import com.github.bhlangonijr.chesslib.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessBoardModelFactory {
    public ChessBoardStoredModel createNewClassicModel(GameInfoModel gameInfoModel) {
        return ChessBoardStoredModel.builder()
                .fen(new Board().getFen())
                .whiteSide(
                        BoardSide.builder()
                                .chessClock(gameInfoModel.getWhiteSide().getClock())
                                .takenPieces(List.of())
                                .build()
                )
                .blackSide(
                        BoardSide.builder()
                                .chessClock(gameInfoModel.getBlackSide().getClock())
                                .takenPieces(List.of())
                                .build()
                )
                .build();
    }
}

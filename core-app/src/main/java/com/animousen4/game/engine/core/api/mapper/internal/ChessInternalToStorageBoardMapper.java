package com.animousen4.game.engine.core.api.mapper.internal;

import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.GameContext;
import org.springframework.stereotype.Component;

@Component
public class ChessInternalToStorageBoardMapper implements Mapper<ChessBoardInternalModel, ChessBoardStoredModel> {


    @Override
    public ChessBoardStoredModel map(ChessBoardInternalModel model) {
        return ChessBoardStoredModel.builder()
                .whiteSide(model.getWhiteSide())
                .blackSide(model.getBlackSide())
                .fen(model.getBoard().getFen())
                .build();
    }
}

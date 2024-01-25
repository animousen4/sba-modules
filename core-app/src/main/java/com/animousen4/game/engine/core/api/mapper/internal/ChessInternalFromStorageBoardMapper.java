package com.animousen4.game.engine.core.api.mapper.internal;

import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.GameContext;
import org.springframework.stereotype.Component;

@Component
public class ChessInternalFromStorageBoardMapper extends Mapper<ChessBoardStoredModel, ChessBoardInternalModel> {

    @Override
    public ChessBoardInternalModel map(ChessBoardStoredModel model) {

        Board board = new Board();
        board.loadFromFen(model.getFen());

        return ChessBoardInternalModel.builder()
                .whiteSide(model.getWhiteSide())
                .blackSide(model.getBlackSide())
                .board(board)
                .build();

    }
}

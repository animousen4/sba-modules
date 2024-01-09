package com.animousen4.game.engine.core.api.mapper.internal;

import com.animousen4.game.engine.core.api.model.game.board.BoardSide;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessInternalFromStorageBoardMapperTest {

    ChessInternalFromStorageBoardMapper mapper;


    @Test
    void testSameFenStorageBoardMapper() {
        mapper = new ChessInternalFromStorageBoardMapper();

        String fen = "8/8/4k1n1/8/1K6/8/8/8 b - - 0 1";
        ChessBoardStoredModel chessBoardStoredModel = new ChessBoardStoredModel(
                fen,
                BoardSide.builder().build(),
                BoardSide.builder().build()
        );

        ChessBoardInternalModel internalModel = mapper.map(chessBoardStoredModel);

        assertEquals(fen, internalModel.getBoard().getFen());
    }

    @Test
    void testAvailableTurnsStorageBoardMapper() {
        mapper = new ChessInternalFromStorageBoardMapper();

        String fen = "8/8/4k1n1/8/1K6/8/8/8 b - - 0 1";
        ChessBoardStoredModel chessBoardStoredModel = new ChessBoardStoredModel(
                fen,
                BoardSide.builder().build(),
                BoardSide.builder().build()
        );

        ChessBoardInternalModel internalModel = mapper.map(chessBoardStoredModel);

        System.out.println(
                internalModel.getBoard().getFen()
        );
        System.out.println(
                internalModel.getBoard().legalMoves()
        );
    }

}

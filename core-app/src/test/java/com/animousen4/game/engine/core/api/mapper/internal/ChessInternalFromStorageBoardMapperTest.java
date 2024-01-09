package com.animousen4.game.engine.core.api.mapper.internal;

import com.animousen4.game.engine.core.api.model.game.board.BoardSide;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChessInternalFromStorageBoardMapperTest {

    ChessInternalFromStorageBoardMapper mapper;


    @Test
    void testSameFenStorageBoardMapper() {
        mapper = new ChessInternalFromStorageBoardMapper();

        String fen = "8/8/4k1n1/8/1K6/8/8/8 b - - 0 1";
        ChessBoardStoredModel chessBoardStoredModel = mock(ChessBoardStoredModel.class);
        when(chessBoardStoredModel.getFen()).thenReturn(fen);

        ChessBoardInternalModel internalModel = mapper.map(chessBoardStoredModel);

        assertEquals(fen, internalModel.getBoard().getFen());
    }

    @Test
    void testLegalTurnStorageBoardMapper() {
        mapper = new ChessInternalFromStorageBoardMapper();

        String fen = "8/8/4k1n1/8/1K6/8/8/8 b - - 0 1";
        ChessBoardStoredModel chessBoardStoredModel = mock(ChessBoardStoredModel.class);
        when(chessBoardStoredModel.getFen()).thenReturn(fen);

        ChessBoardInternalModel internalModel = mapper.map(chessBoardStoredModel);

        assertTrue(internalModel.getBoard().isMoveLegal(
                new Move(Square.G6, Square.F4), true
        ));

    }

    @Test
    void testSidesStorageBoardMapper() {
        mapper = new ChessInternalFromStorageBoardMapper();

        ChessBoardStoredModel chessBoardStoredModel = mock(ChessBoardStoredModel.class);
        String fen = "8/8/4k1n1/8/1K6/8/8/8 b - - 0 1";
        BoardSide boardSideWhite = mock();
        BoardSide boardSideBlack = mock();

        when(chessBoardStoredModel.getBlackSide()).thenReturn(boardSideBlack);
        when(chessBoardStoredModel.getWhiteSide()).thenReturn(boardSideWhite);
        when(chessBoardStoredModel.getFen()).thenReturn(fen);

        ChessBoardInternalModel internalModel = mapper.map(chessBoardStoredModel);

        assertEquals(boardSideWhite, internalModel.getWhiteSide());
        assertEquals(boardSideBlack, internalModel.getBlackSide());

    }

}

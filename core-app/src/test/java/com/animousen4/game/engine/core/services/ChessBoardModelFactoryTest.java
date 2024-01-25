package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.model.game.info.GameInfoModel;
import com.animousen4.game.engine.core.api.model.game.info.SideInfoModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessClock;
import com.github.bhlangonijr.chesslib.Board;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChessBoardModelFactoryTest {

    @InjectMocks
    ChessBoardModelFactory chessBoardModelFactory;

    @Test
    void testModelCreation() {

        String fen = new Board().getFen();
        GameInfoModel gameInfoModel = mock();
        SideInfoModel side = mock();
        ChessClock chessClock = mock();

        when(gameInfoModel.getWhiteSide()).thenReturn(side);
        when(gameInfoModel.getBlackSide()).thenReturn(side);

        when(side.getClock()).thenReturn(chessClock);


        ChessBoardStoredModel storedModel = chessBoardModelFactory.createNewClassicModel(gameInfoModel);

        assertEquals(gameInfoModel.getBlackSide().getClock(), storedModel.getBlackSide().getChessClock());
        assertEquals(gameInfoModel.getWhiteSide().getClock(), storedModel.getWhiteSide().getChessClock());
        assertEquals(fen, storedModel.getFen());
    }
}

package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.board.ChessBoardDTO;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardModel;
import org.springframework.stereotype.Component;

@Component
public class ChessBoardMapper implements ModelDtoMapper<ChessBoardModel, ChessBoardDTO>{
    @Override
    public ChessBoardDTO map(ChessBoardModel chessBoardModel) {
        return ChessBoardDTO.builder()
                .fen(chessBoardModel.getBoard().getFen())
                .whiteSide(chessBoardModel.getWhiteSide())
                .blackSide(chessBoardModel.getBlackSide())
                .build();
    }
}

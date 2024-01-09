package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.board.ChessBoardDTO;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import org.springframework.stereotype.Component;

@Component
public class ChessBoardStoredMapper implements ModelDtoMapper<ChessBoardStoredModel, ChessBoardDTO>{
    @Override
    public ChessBoardDTO map(ChessBoardStoredModel chessBoardStoredModel) {
        return ChessBoardDTO.builder()
                .fen(chessBoardStoredModel.getFen())
                .whiteSide(chessBoardStoredModel.getWhiteSide())
                .blackSide(chessBoardStoredModel.getBlackSide())
                .build();
    }
}

package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.board.ChessBoardDTO;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardModel;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    ChessBoardDTO map(ChessBoardModel chessBoardModel) {
        return ChessBoardDTO.builder()
                .fen()
                .build();
    }
}

package com.animousen4.game.engine.core.api.dto.game;

import com.animousen4.game.engine.core.api.dto.game.board.ChessBoardDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameDTO {
    Long id;

    GameInfoDTO gameInfo;

    ChessBoardDTO chessBoard;
}

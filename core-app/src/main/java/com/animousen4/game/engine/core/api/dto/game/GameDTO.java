package com.animousen4.game.engine.core.api.dto.game;

import com.animousen4.game.engine.core.api.model.game.GameInfoModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardModel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameDTO {
    Long id;

    GameInfoModel gameInfo;

    ChessBoardModel chessBoardModel;
}

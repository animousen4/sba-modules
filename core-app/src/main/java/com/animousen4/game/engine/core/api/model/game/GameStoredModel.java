package com.animousen4.game.engine.core.api.model.game;

import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import com.animousen4.game.engine.core.api.model.game.info.GameInfoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Builder
@Getter
@RedisHash("game")
public class GameStoredModel {
    private Long id;

    private GameInfoModel gameInfoModel;

    private ChessBoardStoredModel chessBoardStoredModel;
}

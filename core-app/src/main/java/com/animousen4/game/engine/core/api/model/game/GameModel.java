package com.animousen4.game.engine.core.api.model.game;

import com.animousen4.game.engine.core.api.model.game.board.ChessBoardModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Builder
@Getter
@RedisHash("game")
public class GameModel {
    Long id;

    GameInfo gameInfo;

    ChessBoardModel chessBoardModel;
}

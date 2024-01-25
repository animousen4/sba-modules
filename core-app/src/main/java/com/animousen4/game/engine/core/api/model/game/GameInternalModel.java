package com.animousen4.game.engine.core.api.model.game;

import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.model.game.info.GameInfoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Builder
@Getter
@Setter
@RedisHash("game")
public class GameInternalModel {
    private Long id;

    private GameInfoModel gameInfoModel;

    private ChessBoardInternalModel chessBoardInternalModel;

}

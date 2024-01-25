package com.animousen4.game.engine.core.api.mapper.game;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.core.api.mapper.NullableMapper;
import com.animousen4.game.engine.core.api.mapper.game.info.GameInfoMapper;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper extends NullableMapper<GameStoredModel, GameDTO> {
    private final ChessBoardStoredMapper chessBoardStoredMapper;

    private final GameInfoMapper gameInfoMapper;

    @Override
    protected GameDTO safeMap(GameStoredModel model) {
        return GameDTO.builder()
                .id(model.getId())
                .chessBoard(chessBoardStoredMapper.map(model.getChessBoardStoredModel()))
                .gameInfo(gameInfoMapper.map(model.getGameInfoModel()))
                .build();
    }
}

package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper implements ModelDtoMapper<GameStoredModel, GameDTO>{
    private final ChessBoardStoredMapper chessBoardStoredMapper;

    private final GameInfoMapper gameInfoMapper;
    @Override
    public GameDTO map(GameStoredModel gameStoredModel) {
        if (gameStoredModel == null)
            return null;
        return GameDTO.builder()
                .id(gameStoredModel.getId())
                .chessBoard(chessBoardStoredMapper.map(gameStoredModel.getChessBoardStoredModel()))
                .gameInfo(gameInfoMapper.map(gameStoredModel.getGameInfoModel()))
                .build();
    }
}

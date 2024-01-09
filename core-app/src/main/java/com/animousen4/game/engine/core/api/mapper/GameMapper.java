package com.animousen4.game.engine.core.api.mapper;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper implements ModelDtoMapper<GameModel, GameDTO>{
    private final ChessBoardMapper chessBoardMapper;

    private final GameInfoMapper gameInfoMapper;
    @Override
    public GameDTO map(GameModel gameModel) {
        return GameDTO.builder()
                .chessBoard(chessBoardMapper.map(gameModel.getChessBoardModel()))
                .gameInfo(gameInfoMapper.map(gameModel.getGameInfoModel()))
                .build();
    }
}

package com.animousen4.game.engine.core.api.mapper.internal;

import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.model.game.GameInternalModel;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChessInternalFromStorageGameMapper extends Mapper<GameStoredModel, GameInternalModel> {

    private final ChessInternalFromStorageBoardMapper chessInternalBoardMapper;

    @Override
    public GameInternalModel map(GameStoredModel model) {
        return GameInternalModel.builder()
                .chessBoardInternalModel(chessInternalBoardMapper.map(model.getChessBoardStoredModel()))
                .gameInfoModel(model.getGameInfoModel())
                .id(model.getId())
                .build();
    }
}

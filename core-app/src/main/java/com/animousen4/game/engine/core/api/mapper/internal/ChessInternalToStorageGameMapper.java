package com.animousen4.game.engine.core.api.mapper.internal;

import com.animousen4.game.engine.core.api.mapper.Mapper;
import com.animousen4.game.engine.core.api.model.game.GameInternalModel;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardInternalModel;
import com.animousen4.game.engine.core.api.model.game.board.ChessBoardStoredModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChessInternalToStorageGameMapper extends Mapper<GameInternalModel, GameStoredModel> {

    private final ChessInternalToStorageBoardMapper internalToStorageBoardMapper;

    @Override
    public GameStoredModel map(GameInternalModel model) {
        return GameStoredModel.builder()
                .id(model.getId())
                .gameInfoModel(model.getGameInfoModel())
                .chessBoardStoredModel(internalToStorageBoardMapper.map(model.getChessBoardInternalModel()))
                .build();
    }
}

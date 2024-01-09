package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.api.mapper.internal.ChessInternalFromStorageGameMapper;
import com.animousen4.game.engine.core.api.mapper.internal.ChessInternalToStorageGameMapper;
import com.animousen4.game.engine.core.api.model.game.GameInternalModel;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrentGameDao {

    private final CurrentGameRepository currentGameRepository;

    private final ChessInternalToStorageGameMapper toStorageBoardMapper;

    private final ChessInternalFromStorageGameMapper fromStorageGameMapper;
    public Optional<GameInternalModel> getCurrentGameById(Long id) {
        return currentGameRepository.findById(id).map(fromStorageGameMapper::map);

    }

    public GameStoredModel saveGame(GameInternalModel gameInternalModel) {
        return currentGameRepository.save(
                toStorageBoardMapper.map(gameInternalModel)
        );
    }


}

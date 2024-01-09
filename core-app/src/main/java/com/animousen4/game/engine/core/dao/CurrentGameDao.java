package com.animousen4.game.engine.core.dao;

import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrentGameDao {

    private final CurrentGameRepository currentGameRepository;
    public Optional<GameModel> getCurrentGameById(Long id) {
        return currentGameRepository.findById(id);
    }
}

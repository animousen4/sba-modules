package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.repositories.entities.game.GameEntity;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GameServiceImpl implements GameService{

    private final CurrentGameRepository currentGameRepository;

    @Override
    public StartGameResult startGameRequest(StartGameCommand command) {
        currentGameRepository.save(
                GameEntity.builder()
                        .id(1111L)
                        .build()
        );
        return StartGameResult.builder()
                .status("STARTED")
                .build();
    }
}

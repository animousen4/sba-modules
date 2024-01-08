package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.repositories.entities.game.GameEntity;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AllCurrentGamesResult getAllCurrentGames() {
        List<GameEntity> games = (List<GameEntity>) currentGameRepository.findAll();
        return AllCurrentGamesResult.builder()
                .games(
                        games.stream()
                                .map(ent -> GameModel.builder()
                                        .name(ent.getId().toString())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }
}

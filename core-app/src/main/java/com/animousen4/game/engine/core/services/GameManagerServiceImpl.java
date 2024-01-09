package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.mapper.GameMapper;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class GameManagerServiceImpl implements GameManagerService {

    private final CurrentGameRepository currentGameRepository;

    private final GameModelFactory gameModelFactory;

    private final GameMapper gameMapper;
    @Override
    public StartGameResult startGame(StartGameCommand command) {
        GameStoredModel gameStoredModel = gameModelFactory.createNewClassicGame(command.getGameInfo());

        currentGameRepository.save(
                gameStoredModel
        );
        return StartGameResult.builder()
                .status("STARTED")
                .gameStoredModel(gameStoredModel)
                .build();
    }

    @Override
    public AllCurrentGamesResult getAllCurrentGames() {
        List<GameStoredModel> games = (List<GameStoredModel>) currentGameRepository.findAll();
        return AllCurrentGamesResult.builder()
                .games(games)
                .build();
    }

    @Override
    public void removeAllCurrentGames() {
        currentGameRepository.deleteAll();
    }
}

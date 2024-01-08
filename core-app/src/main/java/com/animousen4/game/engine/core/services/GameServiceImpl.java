package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class GameServiceImpl implements GameService{

    private final CurrentGameRepository currentGameRepository;

    private final GameModelFactory gameModelFactory;
    @Override
    public StartGameResult startGame(StartGameCommand command) {
        GameModel gameModel = gameModelFactory.createNewClassicGame(command.getGameInfo());
        currentGameRepository.save(
                gameModel
        );
        return StartGameResult.builder()
                .status("STARTED")
                .gameModel(gameModel)
                .build();
    }

    @Override
    public AllCurrentGamesResult getAllCurrentGames() {
        List<GameModel> games = (List<GameModel>) currentGameRepository.findAll();
        return AllCurrentGamesResult.builder()
                .games(games)
                .build();
    }

    @Override
    public void removeAllCurrentGames() {
        currentGameRepository.deleteAll();
    }
}

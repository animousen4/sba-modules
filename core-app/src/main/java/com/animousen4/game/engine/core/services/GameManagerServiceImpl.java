package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.StartGameCommand;
import com.animousen4.game.engine.core.api.mapper.GameMapper;
import com.animousen4.game.engine.core.api.mapper.internal.ChessInternalFromStorageGameMapper;
import com.animousen4.game.engine.core.api.model.game.GameInternalModel;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import com.animousen4.game.engine.core.api.result.AllCurrentGamesResult;
import com.animousen4.game.engine.core.api.result.GetGamePositionResult;
import com.animousen4.game.engine.core.api.result.StartGameResult;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.animousen4.game.engine.core.consts.AppConsts.GAME_ID;
import static com.animousen4.game.engine.core.consts.AppConsts.GAME_NOT_EXISTS;

@Service
@RequiredArgsConstructor
class GameManagerServiceImpl implements GameManagerService {

    private final CurrentGameRepository currentGameRepository;

    private final GameModelFactory gameModelFactory;

    private final ChessInternalFromStorageGameMapper storageGameMapper;

    private final ValidationErrorFactory validationErrorFactory;

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
    public GetGamePositionResult getGamePosition(Long id) {
        Optional<GameStoredModel> gameStoredModel = currentGameRepository.findById(id);

        GameInternalModel gameInternalModel;
        if (gameStoredModel.isPresent()) {
            gameInternalModel = storageGameMapper.map(gameStoredModel.get());
            String pos = gameInternalModel.getChessBoardInternalModel().getBoard().toString();

            return GetGamePositionResult.builder()
                    .position(pos)
                    .build();
        } else
            return GetGamePositionResult.builder()
                    .validationErrors(
                            List.of(
                                   validationErrorFactory.buildError(
                                           GAME_NOT_EXISTS,
                                           new Placeholder(GAME_ID, id)
                                   )
                            )
                    )
                    .build();
    }

    @Override
    public void removeAllCurrentGames() {
        currentGameRepository.deleteAll();
    }
}

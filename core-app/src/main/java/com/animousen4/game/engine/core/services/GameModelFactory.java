package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.model.game.GameInfo;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameModelFactory {

    private final ChessBoardModelFactory chessBoardModelFactory;
    public GameModel createNewClassicGame(GameInfo gameInfo) {
        return GameModel.builder()
                .id(-1L)
                .gameInfo(gameInfo)
                .chessBoardModel(
                        chessBoardModelFactory.createNewClassicModel(gameInfo)
                )
                .build();
    }
}

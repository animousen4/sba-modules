package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.api.model.game.GameInfoModel;
import com.animousen4.game.engine.core.api.model.game.GameModel;
import com.animousen4.game.engine.core.api.model.game.SideInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameModelFactory {

    private final ChessBoardModelFactory chessBoardModelFactory;
    public GameModel createNewClassicGame(GameInfoDTO gameInfoDto) {

        GameInfoModel gameInfoModel = createGameInfo(gameInfoDto);
        return GameModel.builder()
                .id(-1L)
                .gameInfoModel(
                        gameInfoModel
                )
                .chessBoardModel(
                        chessBoardModelFactory.createNewClassicModel(gameInfoModel)
                )
                .build();
    }

    private GameInfoModel createGameInfo(GameInfoDTO gameInfoDTO) {
        return GameInfoModel.builder()
                .whiteSide(
                        SideInfoModel.builder()
                                .sideId(gameInfoDTO.getWhiteSide().getSideId())
                                .clock(gameInfoDTO.getWhiteSide().getClock())
                                .build()
                )
                .blackSide(
                        SideInfoModel.builder()
                                .sideId(gameInfoDTO.getBlackSide().getSideId())
                                .clock(gameInfoDTO.getBlackSide().getClock())
                                .build()
                )
                .build();
    }
}

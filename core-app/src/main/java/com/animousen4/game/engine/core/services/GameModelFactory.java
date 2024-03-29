package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.dto.game.GameInfoDTO;
import com.animousen4.game.engine.core.api.model.game.info.GameInfoModel;
import com.animousen4.game.engine.core.api.model.game.GameStoredModel;
import com.animousen4.game.engine.core.api.model.game.info.SideInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameModelFactory {

    private final ChessBoardModelFactory chessBoardModelFactory;
    public GameStoredModel createNewClassicGame(GameInfoDTO gameInfoDto, Long id) {

        GameInfoModel gameInfoModel = createGameInfo(gameInfoDto);
        return GameStoredModel.builder()
                .id(id)
                .gameInfoModel(
                        gameInfoModel
                )
                .chessBoardStoredModel(
                        chessBoardModelFactory.createNewClassicModel(gameInfoModel)
                )
                .build();
    }

    private GameInfoModel createGameInfo(GameInfoDTO gameInfoDto) {
        return GameInfoModel.builder()
                .whiteSide(
                        SideInfoModel.builder()
                                .sideId(gameInfoDto.getWhiteSide().getSideId())
                                .clock(gameInfoDto.getWhiteSide().getClock())
                                .build()
                )
                .blackSide(
                        SideInfoModel.builder()
                                .sideId(gameInfoDto.getBlackSide().getSideId())
                                .clock(gameInfoDto.getBlackSide().getClock())
                                .build()
                )
                .build();
    }
}

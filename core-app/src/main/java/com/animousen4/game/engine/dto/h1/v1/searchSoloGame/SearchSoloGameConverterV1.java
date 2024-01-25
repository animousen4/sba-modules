package com.animousen4.game.engine.dto.h1.v1.searchSoloGame;

import com.animousen4.game.engine.core.api.command.MakeMoveCommand;
import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.api.mapper.game.info.room.solo.SoloGameInfoMapper;
import com.animousen4.game.engine.core.api.result.MakeMoveResult;
import com.animousen4.game.engine.core.api.result.SoloGameSearchResult;
import com.animousen4.game.engine.dto.h1.AbstractConverter;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloGameInfoDto;
import com.animousen4.game.engine.dto.h1.v1.makeMove.MakeMoveRequestV1;
import com.animousen4.game.engine.dto.h1.v1.makeMove.MakeMoveResponseV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchSoloGameConverterV1 implements AbstractConverter<SoloGameSearchRequest, SoloGameSearchCommand, SoloGameSearchResponse, SoloGameSearchResult> {

    private final SoloGameInfoMapper soloGameInfoMapper;
    @Override
    public SoloGameSearchCommand buildCommand(SoloGameSearchRequest request) {
        return SoloGameSearchCommand.builder()
                .soloGameInfoModel(soloGameInfoMapper.map(request.getGameInfo()))
                .build();
    }

    @Override
    public SoloGameSearchResponse buildResponse(SoloGameSearchResult result) {
        return SoloGameSearchResponse.builder()
                .searchRequestId(result.getRequestId())
                .build();
    }
}

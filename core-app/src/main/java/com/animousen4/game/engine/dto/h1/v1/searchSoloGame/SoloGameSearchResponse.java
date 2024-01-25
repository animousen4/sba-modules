package com.animousen4.game.engine.dto.h1.v1.searchSoloGame;

import com.animousen4.game.engine.dto.h1.CoreRequest;
import com.animousen4.game.engine.dto.h1.CoreResponse;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloGameInfoDto;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class SoloGameSearchResponse extends CoreResponse {
    String searchRequestId;
}

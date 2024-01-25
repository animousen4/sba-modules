package com.animousen4.game.engine.dto.h1.v1.searchSoloGame;

import com.animousen4.game.engine.dto.h1.CoreRequest;
import com.animousen4.game.engine.dto.h1.CoreResponse;
import com.animousen4.game.engine.dto.h1.entities.room.solo.SoloGameInfoDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Getter
public class SoloGameSearchResponse extends CoreResponse {
    String searchRequestId;
}

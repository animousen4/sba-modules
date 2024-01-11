package com.animousen4.game.engine.dto.h1.v1.getAllCurrentGames;

import com.animousen4.game.engine.core.api.dto.game.GameDTO;
import com.animousen4.game.engine.dto.h1.CoreResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class GetAllCurrentGamesResponseV1 extends CoreResponse {
    // not use model!
    List<GameDTO> games;
}
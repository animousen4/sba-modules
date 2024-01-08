package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.core.api.model.game.GameModel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@Getter
public class AllCurrentGamesResult extends CoreResult{
    List<GameModel> games;
}

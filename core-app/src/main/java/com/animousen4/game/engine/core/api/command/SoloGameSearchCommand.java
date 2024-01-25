package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.model.game.info.SoloGameInfoModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SoloGameSearchCommand extends CoreCommand{
    SoloGameInfoModel soloGameInfoModel;
}

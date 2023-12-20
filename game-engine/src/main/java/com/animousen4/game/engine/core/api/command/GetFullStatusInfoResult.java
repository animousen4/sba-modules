package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.dto.FullStatusInfoDto;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class GetFullStatusInfoResult extends AbstractResult{
    FullStatusInfoDto fullStatusInfo;
}

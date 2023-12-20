package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.dto.StatusInfoDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class GetFullStatusInfoResult extends AbstractResult{
    StatusInfoDto statusInfo;
}

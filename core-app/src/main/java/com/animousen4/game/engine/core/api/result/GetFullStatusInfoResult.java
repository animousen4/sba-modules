package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.core.api.dto.StatusInfoDto;
import com.animousen4.game.engine.core.api.result.CoreResult;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class GetFullStatusInfoResult extends CoreResult {
    StatusInfoDto statusInfo;
}

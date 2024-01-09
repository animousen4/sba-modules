package com.animousen4.game.engine.core.api.dto;

import com.animousen4.game.engine.core.values.UserStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatusInfoDto {
    UserStatus statusName;

}
